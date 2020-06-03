package ua.testing.model.service;

import org.junit.Before;
import org.junit.Test;
import ua.testing.model.entity.User;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class UserServiceTest {
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        this.userService = new UserService();
    }

    @Test
    public void getAllUsersTest() {
        List<User> users = userService.getAllUsers("ua");
        assertTrue(users.size() > 0);
    }

    @Test
    public void createUserTest() {
        List<User> usersBeforeUserCreating = userService.getAllUsers("ua");

        String email = "user@domen.com";
        String password = "password";

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        userService.createUser(newUser);

        List<User> usersAfterUserCreating = userService.getAllUsers("ua");
        assertThat(usersAfterUserCreating.size() - usersBeforeUserCreating.size(), is(1));

        User user = userService.getUserByEmailAndPassword(email, password);
        userService.deleteUser(user.getId());
    }

    @Test
    public void getUserByIdTest() {
        User user = userService.getUserById(1);
        assertThat(user.getId(), is(1));
    }

    @Test
    public void getUserByEmailAndPassword() {
        String email = "user@domen.com";
        String password = "password";

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        userService.createUser(newUser);

        User user = userService.getUserByEmailAndPassword(email, password);

        assertThat(user.getEmail(), is(email));
        assertThat(user.getPassword(), is(password));
        userService.deleteUser(user.getId());
    }
}
