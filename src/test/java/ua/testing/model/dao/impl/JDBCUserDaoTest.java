package ua.testing.model.dao.impl;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import ua.testing.model.entity.User;

import java.sql.Connection;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class JDBCUserDaoTest {
    private Connection connection;
    private JDBCUserDao userDao;
    private JDBCUserDao jdbcUserDao = mock(JDBCUserDao.class);

    @Before
    public void setUp() throws Exception {
        this.userDao = new JDBCUserDao(connection);
    }

    @Test
    public void findByIdTest_Should_Return_True() throws Exception {
        User user = userDao.findById(1);
        assertThat(user).isNotNull();
    }
}
