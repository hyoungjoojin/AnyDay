package com.anyday.user.dto.response;

import com.anyday.user.constant.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorDto implements ResponseDto {
  private final boolean success = false;
  private final String data = "";

  private ErrorDto error;

  @Data
  public static class ErrorDto {
    private String code;
    private String message;

    public ErrorDto(ErrorCode errorCode) {
      this.code = errorCode.getCode();
      this.message = errorCode.getMessage();
    }
  }
}
