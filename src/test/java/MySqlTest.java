import com.example.servletDemo.dao.UserDaoImplement;
import com.example.servletDemo.entity.User;

public class MySqlTest {
    public static void main(String[] args) {
        UserDaoImplement userDaoImplement = new UserDaoImplement();
//        User user = new User() ;
//        for (int i = 1; i < 101; i++) {
//            user.setSex("男");
//            user.setId(i);
//            user.setAge(i+2);
//            user.setUsername("user"+i);
//            userDaoImplement.insert(user);
//        }
        System.out.println(userDaoImplement.getTotal(0,8).toString());

    }
}
