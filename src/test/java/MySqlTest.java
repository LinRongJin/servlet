import com.example.servletDemo.dao.UserDaoImplement;
import com.example.servletDemo.entity.User;

public class MySqlTest {
    public static void main(String[] args) {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
        User user = new User() ;
        user.setSex("男");
        user.setId(26);
        user.setUsername("zhgon");
        user.setAge(23);
        userDaoImplement.insert(user);
    }
}
