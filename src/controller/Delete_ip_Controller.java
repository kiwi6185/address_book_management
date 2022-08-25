package controller;

import javax.swing.*;
import java.sql.*;

/**
 * Created on 2021/12/24 - 10:46.
 *
 * @author CaseyLee
 */
public class Delete_ip_Controller {

    Connection con;
    PreparedStatement preSql;   // 预处理语句 对象
    Statement sql;
    ResultSet rs;

    public Delete_ip_Controller(){
        GetDBConnnected gdbc = new GetDBConnnected();
        con = gdbc.getConnection();
    }

    public boolean delete(String ID){

        try {

            sql = con.createStatement();
            rs = sql.executeQuery("select * from ip_record"); //查询表

            while (rs.next()) {

                if (rs.getString(2).equals(ID)) {

                    String name = rs.getString(2);

                    sql.executeUpdate("delete from ip_record where name = \'" + ID + "\'");

                    JOptionPane.showMessageDialog(null, name +
                            "的 ip 删除成功", "恭喜", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                    rs.close();
                    return true;

                }

            }

            con.close();
            rs.close();

            JOptionPane.showMessageDialog(null, "查无此人，请重新输入",
                    "警告", JOptionPane.ERROR_MESSAGE);
            return false;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

}
