package com.hsbc.test.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingsResponse extends BaseResponse{
    private List<?> response;
}
