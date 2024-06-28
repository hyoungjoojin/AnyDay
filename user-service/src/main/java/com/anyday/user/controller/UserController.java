package com.anyday.user.controller;

import com.anyday.user.constant.ErrorCode;
import com.anyday.user.dto.response.ResponseDto;
import com.anyday.user.dto.response.ResponseErrorDto;
import com.anyday.user.dto.response.ResponseErrorDto.ErrorDto;
import com.anyday.user.dto.response.ResponseSuccessDto;
import com.anyday.user.dto.response.ResponseSuccessDto.GetUserResponseDataDto;
import com.anyday.user.exception.UserNotFoundException;
import com.anyday.user.model.User;
import com.anyday.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
  @Autowired @Lazy private UserService userService;

  @GetMapping("/{uid}")
  public ResponseEntity<ResponseDto> getUser(@PathVariable String uid) {
    String path = "/user/" + uid;
    log.info("HTTP GET " + path);

    ResponseDto responseBody;
    HttpHeaders responseHeaders = new HttpHeaders();
    HttpStatus responseStatus;

    try {
      User user = this.userService.getUser(uid);

      responseStatus = HttpStatus.OK;
      responseHeaders.add(HttpHeaders.CACHE_CONTROL, "30");
      responseBody =
          new ResponseSuccessDto<GetUserResponseDataDto>(
              GetUserResponseDataDto.builder()
                  .uid(user.getUid())
                  .juid(user.getJuid())
                  .email(user.getEmail())
                  .firstName(user.getFirstName())
                  .lastName(user.getLastName())
                  .build());

      log.info("HTTP Status OK " + path);

    } catch (UserNotFoundException e) {
      responseStatus = HttpStatus.NOT_FOUND;
      responseBody = new ResponseErrorDto(new ErrorDto(ErrorCode.USER_NOT_FOUND));

      log.info("HTTP Status NOT_FOUND " + path);
    }

    return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
  }
}
