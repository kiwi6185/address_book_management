package controller;

import java.sql.*;

/**
 * Created on 2021/12/24 - 8:43.
 *
 * @author CaseyLee
 */
public class Show_ip_Controller {

    Connection con;
    PreparedStatement preSql;   // 预处理语句 对象
    Statement sql;
    ResultSet rs;
    String[] columnName;
    String[][] record;
    static int order = 0;  //升序 0；降序 1。

    public Show_ip_Controller(){

        GetDBConnnected gdbc = new GetDBConnnected();
        con = gdbc.getConnection();
    }

    public String[] getColumnName(){

        try{
            sql = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from ip_record ORDER BY ID");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();    //字段数目
            columnName = new String[columnCount];
            for(int i = 1; i <= columnCount; i++){
                columnName[i - 1] = metaData.getColumnName(i);
            }
            rs.last();
            int recordAmount = rs.getRow();
            record = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();
            while (rs.next()){
                for(int j = 1; j <= columnCount; j++){
                    record[i][j - 1] = rs.getString(j);
                }
                i++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        if(columnName == null){
            System.out.println("先查询记录");
            return null;
        }
        return columnName;
    }

    //Ascend_Or_Descend = 0：不需要升降序
    //Ascend_Or_Descend = 1：需要
    public String[][]getRecord(int Ascend_Or_Descend) {

        try{
            sql = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            if(Ascend_Or_Descend == 1) {
                if (order == 0) {
                    rs = sql.executeQuery("select * from ip_record ORDER BY ID");
                    order = 1;
                } else if (order == 1) {
                    rs = sql.executeQuery("select * from ip_record ORDER BY ID desc");
                    order = 0;
                }
                System.out.println("order = " + order);
            }
            else{
                rs = sql.executeQuery("select * from ip_record");
            }
            System.out.println(order);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();    //字段数目
            columnName = new String[columnCount];
            for(int i = 1; i <= columnCount; i++){
                columnName[i - 1] = metaData.getColumnName(i);
            }
            rs.last();
            int recordAmount = rs.getRow();
            record = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();
            while (rs.next()){
                for(int j = 1; j <= columnCount; j++){
                    record[i][j - 1] = rs.getString(j);
                }
                i++;
            }
            System.out.println(order);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return record;
    }

    public void show_IP(){
        try {

            sql = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from ip_record");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();    //字段数目
            columnName = new String[columnCount];
            for(int i = 1; i <= columnCount; i++){
                columnName[i - 1] = metaData.getColumnName(i);
            }
            rs.last();
            int recordAmount = rs.getRow();
            record = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();
            while (rs.next()){
                for(int j = 1; j <= columnCount; j++){
                    record[i][j - 1] = rs.getString(j);
                }
                i++;
            }

            con.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
