package com.anyday.user.constant;

public enum ErrorCode {
  USER_NOT_FOUND("USER_NOT_FOUND", "User not found.");

  private final String code;
  private final String message;

  private ErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
