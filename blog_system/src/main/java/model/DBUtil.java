package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

//使用这个类和数据建立连接
public class DBUtil {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/BlogSystem?characterEncoding=utf8&&useSSL=false";
    private static final String USERNAME="root";
    private static final String PASSWORD="";


    private  static  volatile DataSource dataSource=null;
    private  static  DataSource getDataSource(){
        if (dataSource == null){
            synchronized(DBUtil.class){
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setUrl(URL);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                    ((MysqlDataSource) dataSource).setUser(USERNAME);
                }
            }
        }
        return dataSource;
    }
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
