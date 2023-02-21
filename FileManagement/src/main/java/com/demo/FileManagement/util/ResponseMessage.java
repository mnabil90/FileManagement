package com.demo.FileManagement.util;

import lombok.Data;

@Data
public class ResponseMessage {
  private boolean isSuccess;
  private String message;
  private Object data;
}
