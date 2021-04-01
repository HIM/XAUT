package xaut.dao.Impl;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Repository;
        import xaut.dao.UserDao;
        import xaut.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void addUser(User user) {
//        System.out.println("add a u");
        String sql = "insert into user values(null,?,?)";
        Object param[] = {user.getUsername(), user.getPassword()};
        this.jdbcTemplate.update(sql, param);
    }

}
