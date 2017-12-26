package study.com.greendaodemo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/12/26.
 */
@Entity
public class User {
    @Property()
    private Long id;
    private String nickName;
    private int age;
    private String address;
    @Generated(hash = 1381797870)
    public User(Long id, String nickName, int age, String address) {
        this.id = id;
        this.nickName = nickName;
        this.age = age;
        this.address = address;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }




}
