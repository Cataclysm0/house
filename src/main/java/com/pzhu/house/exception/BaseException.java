package com.pzhu.house.exception;

import lombok.Getter;
import lombok.Setter;

public class BaseException extends RuntimeException{

    @Getter
    @Setter
    private Integer code;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }


}
