import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) throws SQLException {
        //1.创建数据源
        DataSource dataSource=new MysqlDataSource();
        //设置数据库所在的地址
        ((MysqlDataSource)dataSource).
                setURL("jdbc:mysql://127.0.0.1:3306/java102?characterEncoding=utf8&useSSL=false");
        //设置登录数据库的用户名
        ((MysqlDataSource)dataSource).setUser("root");
        //设置登录数据库的密码
        ((MysqlDataSource)dataSource).setPassword("123456");

        //2.让代码与数据库服务器建立连接
        Connection connection=dataSource.getConnection();

        //3.操作数据库，以插入数据为例
        //  关键所在就是构造一个SQL语句
        String sql="insert into student(sn,name) value(?,?)";
        //  然后将这个String类型的sql语句，
        //  放进执行sql的API中，使之在连接的数据库中生效
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setString(1,"09999");
        statement.setString(1,"杜海庆");
        System.out.println(statement);

        //4.执行SQL，相当于扫码取件
        //  SQL里面如果是insert ，update，delete，都使用 executeUpdate方法。
        //  SQL里面如果是select ，则使用executeQuery。
        //  这里的返回值表示这个操作，影响到了几行，就相当于在控制台里输入sql之后得到的数字。
        int ret = statement.executeUpdate();
        System.out.println(ret);

        statement.close();
        connection.close();
    }
}
