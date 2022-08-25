package controller;

import model.Register;
import model.Update;

import javax.swing.*;
import java.sql.*;

/**
 * Created on 2021/12/23 - 16:08.
 *
 * @author CaseyLee
 */

public class InsertController {
    Connection con;
    PreparedStatement preSql;   // 预处理语句 对象

    public InsertController(){
        GetDBConnnected gdbc = new GetDBConnnected();
        con = gdbc.getConnection();
    }

    public boolean writeRegisterModel(Register register){

        String sqlStr = "insert into user values(?, ?, ?, ?)";
        int ok = 0;
        try{
            preSql = con.prepareStatement(sqlStr);  // 得到预处理语句对象preSql
            preSql.setString(1, register.getId());          // 设置第一个？
            preSql.setString(2, register.getName());    // 设置第二个？
            preSql.setString(3, register.getPassword());    // 设置第三个？
            preSql.setString(4, "0");                    // 设置第四个？
            ok = preSql.executeUpdate();
            con.close();
        }
        catch (SQLException exception){
            JOptionPane.showMessageDialog(null, "id不能重复",
                    "警告", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(ok != 0){
            JOptionPane.showMessageDialog(null, "注册成功",
                    "恭喜", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        return false;
    }
}