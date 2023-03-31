package com.hsbc.test.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private String message;
    private int code;
}
