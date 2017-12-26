package study.com.greendaodemo.dao;

import android.content.Context;

import java.util.List;

import study.com.greendaodemo.UserHelper;

/**
 * Created by Administrator on 2017/12/26.
 */

public class DaoManager {

    private final Context context;
    private final DaoSession daoSession;

    public DaoManager(Context context) {
        this.context = context;
        UserHelper openHelper = new UserHelper(context, "user.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }

    public boolean insertUser(User user) {
        long insert = daoSession.insert(user);
        return insert > 0 ? true : false;
    }

    public void deleteUser(User user) {
        daoSession.delete(user);
    }

    public void updateUser(User user) {
        daoSession.update(user);
    }

    public List<User> queryAllUser() {
        List<User> list = daoSession.queryBuilder(User.class).build().list();
        return list;
    }
}
