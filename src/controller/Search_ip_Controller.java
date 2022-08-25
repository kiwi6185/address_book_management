package controller;

import model.Record;
import model.Search;
import view.ChatRoom_View;
import view.Communication_ip_View;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created on 2021/12/24 - 23:18.
 *
 * @author CaseyLee
 */
public class Search_ip_Controller {

    Connection con;
    Statement sql;
    ResultSet rs;

    public Search_ip_Controller(){
        GetDBConnnected gdbc = new GetDBConnnected();
        con = gdbc.getConnection();
    }

    public Record search(String name){

        Record record = new Record();
        record.setName(name);

        try {

            sql = con.createStatement();
            rs = sql.executeQuery("select * from ip_record where name = " + "\'" + record.getName() +"\'"); //查询表

            if(rs.next()){     //找到人啦，因为返回的rs是一张新的表

                record.setIp(rs.getString(3));
                return record;

            }
            else {

                JOptionPane.showMessageDialog(null, "查无此人，请重新输入",
                        "警告", JOptionPane.ERROR_MESSAGE);
                return null;    //查不到此ID

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}