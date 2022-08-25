package controller;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created on 2021/12/23 - 22:32.
 *
 * @author CaseyLee
 */
public class SearchController {

    Connection con;
    Statement sql;
    ResultSet rs;

    public SearchController(){
        GetDBConnnected gdbc = new GetDBConnnected();
        con = gdbc.getConnection();
    }

    public boolean IsUserID_Exist_n_password_verified(String ID, String psw) {
        try {

            sql = con.createStatement();
            rs = sql.executeQuery("select * from user"); //查询表

            while (rs.next()) {

                if (rs.getString(1).equals(ID)) {

                    if(rs.getString(3).equals(psw)){    //登录成功
                        JOptionPane.showMessageDialog(null, "欢迎回来，" + rs.getString(2),
                                "恭喜", JOptionPane.INFORMATION_MESSAGE);
                        return true;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "请重新输入密码",
                                "警告", JOptionPane.ERROR_MESSAGE);
                        return false;   //找到这个ID了，但密码错误
                    }

                }

            }
            con.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "请重新输入ID",
                "警告", JOptionPane.ERROR_MESSAGE);
        return false;   //找不到这个ID
    }
}
