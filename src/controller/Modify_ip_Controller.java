package controller;

import javax.swing.*;
import java.sql.*;

/**
 * Created on 2021/12/25 - 10:00.
 *
 * @author CaseyLee
 */
public class Modify_ip_Controller {

    Connection con;
    PreparedStatement preSql;   // 预处理语句 对象
    Statement sql;
    ResultSet rs;

    public Modify_ip_Controller(){
        GetDBConnnected gdbc = new GetDBConnnected();
        con = gdbc.getConnection();
    }

    public boolean modify(String ID, String name, String ip){

        String sqlStr = "update ip_record set name = ?, IP = ? where ID = ?";
        int ok = 0;
        try{
            preSql = con.prepareStatement(sqlStr);  // 得到预处理语句对象preSql
            preSql.setString(1, name);          // 设置第一个？
            preSql.setString(2, ip);    // 设置第二个？
            preSql.setString(3, ID);    // 设置第三个？
            ok = preSql.executeUpdate();
            con.close();
        }
        catch (SQLException exception){
            JOptionPane.showMessageDialog(null, "查不到此ID",
                    "警告", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(ok != 0){
            JOptionPane.showMessageDialog(null, "修改记录成功",
                    "恭喜", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

}
