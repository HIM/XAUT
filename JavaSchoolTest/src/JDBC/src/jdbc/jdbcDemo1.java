package jdbc;

public class jdbcDemo1 {
    public static void main(String[] args) {
        try {
            //1.驱动注册
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
