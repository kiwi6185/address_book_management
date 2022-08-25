package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 2021/12/23 - 16:56.
 *
 * @author CaseyLee
 */
public class GetDBConnnected {

    Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/信息管理系统?" +
                            "&useSSL=true&serveTimezone=CST&characterEncoding=GBK",
                    "xxx",
                    "xxx" );
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到数据库驱动");
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
        return con;
    }

}
