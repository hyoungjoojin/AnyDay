package com.anyday.user.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.anyday.user.exception.UserNotFoundException;
import com.anyday.user.model.User;
import com.anyday.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {
  @Autowired private MockMvc mockMvc;

  @MockBean private UserService userService;

  @Test
  public void getUser_userDoesNotExist() throws Exception {
    String uid = "does_not_exist";
    String url = "/user/" + uid;

    when(this.userService.getUser(uid)).thenThrow(UserNotFoundException.class);

    this.mockMvc
        .perform(get(url))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.success").value(false))
        .andExpect(jsonPath("$.data").isEmpty());
  }

  @Test
  public void getUser_userDoesExist() throws Exception {
    String uid = "1";
    String url = "/user/" + uid;

    String email = "test@test.com";
    String juid = "test_juid";
    String firstName = "test_firstName";
    String lastName = "test_lastName";

    User user =
        User.builder()
            .uid(uid)
            .juid(juid)
            .email(email)
            .firstName(firstName)
            .lastName(lastName)
            .build();

    when(this.userService.getUser(uid)).thenReturn(user);

    this.mockMvc
        .perform(get(url))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andExpect(jsonPath("$.data.uid").value(uid))
        .andExpect(jsonPath("$.data.juid").value(juid))
        .andExpect(jsonPath("$.data.email").value(email))
        .andExpect(jsonPath("$.data.firstName").value(firstName))
        .andExpect(jsonPath("$.data.lastName").value(lastName));
  }
}
