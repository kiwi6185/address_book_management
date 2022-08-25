package model;

/**
 * Created on 2021/12/23 - 15:27.
 *
 * @author CaseyLee
 */
// 登陆模型
public class Login {
    boolean loginSuccess = false;   // 是否登陆成功
    boolean admin = false;          // 是否是管理员
    String id;                      // 用户id
    String password;                // 用户密码

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean getLoginSuccess(){
        return this.loginSuccess;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getAdmin(){
        return this.admin;
    }
}
