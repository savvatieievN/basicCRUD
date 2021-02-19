import Model.User;
import Services.UserService;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  throws SQLException {
        System.out.println("123");
        UserService test = new UserService();
        User testUser = new User();
        testUser.setName("Nikolay");
        testUser.setDescription("My name");
        test.save(testUser);
        test.update(testUser);
        System.out.println(test.findById(1).toString());
        System.exit(-1);
    }
}
