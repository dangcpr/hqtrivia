package com.hqtrivia.dang.model.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppErrorResponse extends RuntimeException {
    private int code;
    private String message;

    public AppErrorResponse() {
        this.code = 500;
        this.message = "Internal Server Error";
    }

    public AppErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
