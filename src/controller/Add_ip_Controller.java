package controller;

import model.Login;
import model.Register;
import model.Update;

import javax.swing.*;
import java.sql.*;

/**
 * Created on 2021/12/24 - 16:20.
 *
 * @author CaseyLee
 */
public class Add_ip_Controller {

    Connection con;
    PreparedStatement preSql;   // 预处理语句 对象
    Statement sql;
    ResultSet rs;

    public Add_ip_Controller(){
        GetDBConnnected gdbc = new GetDBConnnected();
        con = gdbc.getConnection();
    }

    public Update add(String ID, String name, String ip){

        String sqlStr = "insert into ip_record values(?, ?, ?)";
        int ok = 0;
        Update update = new Update();

        try{
            preSql = con.prepareStatement(sqlStr);  // 得到预处理语句对象preSql
            preSql.setString(1, ID);          // 设置第一个？
            preSql.setString(2, name);    // 设置第二个？
            preSql.setString(3, ip);    // 设置第三个？
            ok = preSql.executeUpdate();
            con.close();
        }
        catch (SQLException exception){
            JOptionPane.showMessageDialog(null, "id不能重复",
                    "警告", JOptionPane.ERROR_MESSAGE);
            return update;
        }
        if(ok != 0){
            JOptionPane.showMessageDialog(null, "添加记录成功",
                    "恭喜", JOptionPane.INFORMATION_MESSAGE);
            update.setSuccessOrNot(true);
            return update;
        }
        return update;
    }

}
