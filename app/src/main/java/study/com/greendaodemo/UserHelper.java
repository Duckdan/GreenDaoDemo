package study.com.greendaodemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import study.com.greendaodemo.dao.DaoMaster;
import study.com.greendaodemo.dao.UserDao;

/**
 * Created by Administrator on 2017/12/26.
 */

public class UserHelper extends DaoMaster.OpenHelper {
    public UserHelper(Context context, String name) {
        super(context, name);
    }

    public UserHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.e("receiver", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");

        MigrationHelper.migrate(db, UserDao.class, UserDao1.class);
    }
}
