package com.anyday.user.service;

import static org.junit.Assert.fail;

import com.anyday.user.exception.UserNotFoundException;
import com.anyday.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

@SpringBootTest
public class UserServiceTest {
  @Autowired @Lazy private UserService userService;

  @Test
  public void getUser_userDoesNotExist() {
    String uid = "does_not_exist";
    try {
      this.userService.getUser(uid);
      fail("User does not exist, but assertion is not raised");
    } catch (UserNotFoundException e) {
      return;
    }
  }

  @Test
  public void getUser_userDoesExist() {
    String uid = "1";
    User user = null;
    try {
      user = this.userService.getUser(uid);
    } catch (UserNotFoundException e) {
      fail("User exists, but exception is raised.");
      return;
    }

    if (user != null) return;
    fail("User exists, but returned user is null.");
  }
}
