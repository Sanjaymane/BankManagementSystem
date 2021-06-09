package com.cts.loan.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseVO<T> {

    private String statusCode;

    private String message;

    private T result;

}

