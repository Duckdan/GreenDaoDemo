package study.com.greendaodemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import study.com.greendaodemo.dao.DaoManager;
import study.com.greendaodemo.dao.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private ListView lv;
    private DaoManager daoManager;
    private ArrayAdapter<User> adapter;
    private List<User> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        daoManager = new DaoManager(this);
        lv = (ListView) findViewById(R.id.lv);
        lists = new ArrayList<>();
        adapter = new ArrayAdapter<User>(this, R.layout.list_layout, lists) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = View.inflate(MainActivity.this, R.layout.list_layout, null);
                TextView tv1 = (TextView) convertView.findViewById(R.id.tv1);
                TextView tv2 = (TextView) convertView.findViewById(R.id.tv2);
                TextView tv3 = (TextView) convertView.findViewById(R.id.tv3);
                User user = lists.get(position);
                tv1.setText(user.getId() + "");
                tv2.setText(user.getNickName());
                tv3.setText(user.getAge() + "");
                return convertView;
            }
        };
        lv.setAdapter(adapter);
    }

    private long i = 0;


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:  //增
                i++;
                boolean user = daoManager.insertUser(new User(i, "张飞" + i, (int) (100 + i),null));
                if (user) {
                    Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt2:  //删
                break;
            case R.id.bt3:  //改
                break;
            case R.id.bt4:  //查
                lists.clear();
                lists.addAll(daoManager.queryAllUser());
                Toast.makeText(this, "条目数" + lists.size(), Toast.LENGTH_SHORT).show();
                Log.e("receiver", lists.toString());
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
