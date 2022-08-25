package model;

/**
 * Created on 2021/12/23 - 15:54.
 *
 * @author CaseyLee
 */

// 查询模型
public class Search {
    String databaseName = "";   // 数据库名
    String SQL;                 // sql语句
    String[] columnName;        // 全部字段(列)名
    String [][] record;         // 查询结果

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void setSQL(String SQL) {
        this.SQL = SQL;
    }

    public void setRecord(String[][] record) {
        this.record = record;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getSQL() {
        return SQL;
    }

    public String[][] getRecord() {
        return record;
    }

    public void setColumnName(String[] columnName) {
        this.columnName = columnName;
    }

    public String[] getColumnName() {
        return columnName;
    }
}
