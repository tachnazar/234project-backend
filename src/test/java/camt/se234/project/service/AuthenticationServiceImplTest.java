package camt.se234.project.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import camt.se234.project.dao.UserDao;
import camt.se234.project.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {
   UserDao userDao;
   AuthenticationServiceImpl authenticationService;

   @Before
   public void setup() {
      userDao = mock(UserDao.class);
      authenticationService = new AuthenticationServiceImpl();
      authenticationService.setUserDao(userDao);
   }

   @Test
   public void testAuthenicateWithMock() {
      when(userDao.getUser("admin", "admin")).thenReturn(new User("admin", "admin", "admin"));
      when(userDao.getUser("user", "user")).thenReturn(new User("user", "user", "user"));
      assertThat(authenticationService.authenticate("admin", "admin"), is(new User("admin", "admin", "admin")));
      assertThat(authenticationService.authenticate("user", "user"), is(new User("user", "user", "user")));
      assertThat(authenticationService.authenticate("sen", "sen"), is(nullValue()));

   }
}

