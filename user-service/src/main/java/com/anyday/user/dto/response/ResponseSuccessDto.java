package com.anyday.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSuccessDto<T> implements ResponseDto {
  private final boolean success = true;

  private T data;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class GetUserResponseDataDto {
    private String uid;
    private String juid;
    private String email;
    private String firstName;
    private String lastName;
  }
}
