package camt.se234.project.service;

import camt.se234.project.dao.UserDao;
import camt.se234.project.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {
   UserDao userDao;
   AuthenticationServiceImpl authenticationService;

   @Before
    public void setup(){
       userDao=mock(UserDao.class);
       authenticationService=new AuthenticationServiceImpl();
       authenticationService.setUserDao(userDao);
   }
   @Test
    public void authenticationWithMock(){
       List<User> mockUsers=new ArrayList<>();
       mockUsers.add(new User((long) 124,"men","men","admin"));
       when(userDao.findAll()).thenReturn(mockUsers);
       assertThat(authenticationService.authenticate("men","men"),is(new User((long) 124,"men","men","admin")));
       assertThat(authenticationService.authenticate("men","sen"),is(nullValue()));
   }

}
