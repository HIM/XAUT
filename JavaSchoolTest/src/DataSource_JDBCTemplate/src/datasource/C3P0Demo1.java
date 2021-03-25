package datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();//获取数据库连接池对象
        Connection conn = ds.getConnection();//获取连接对象
        System.out.println(conn);
    }
}
