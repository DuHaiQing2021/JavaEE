import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {

    public static void main(String[] args) throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java102?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        Connection connection=dataSource.getConnection();

        String sql="select * from student";
        PreparedStatement statement=connection.prepareStatement(sql);
        //使用ResultSet表示这个表
        ResultSet resultSet=statement.executeQuery();
        //5.遍历结果集合（返回的临时表），先获取到每一行，在获取到这一行中的若干列
        //  next 方法表示获取一行记录，同时把光标往后移动一行
        //  如果遍历到表的结束位置，此处的next直接返回false了
        while (resultSet.next()){
            //针对当前这一行来获取到其中的列
            String sn=resultSet.getString("sn");
            String name=resultSet.getString("name");
            System.out.println("sn:"+sn+"\t name:"+name);
        }
    }

}
