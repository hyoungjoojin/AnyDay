package com.anyday.user.service;

import com.anyday.user.exception.UserNotFoundException;
import com.anyday.user.model.User;
import com.anyday.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired @Lazy private UserRepository userRepository;

  public User getUser(String uid) throws UserNotFoundException {
    User user = this.userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException());
    return user;
  }
}
