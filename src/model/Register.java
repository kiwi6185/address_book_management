package model;

/**
 * Created on 2021/12/23 - 15:27.
 *
 * @author CaseyLee
 */

// 注册模型
public class Register {
    String id;          // 注册者id
    String name;    // 注册者姓名
    String password;    // 注册者密码
    boolean admin;       // 是否为管理员，不允许注册为管理员

    //注册者不能是管理员
    public Register(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
        this.admin = false;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getAdmin() {
        return admin;
    }
}
