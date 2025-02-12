package com.hqtrivia.dang.model.enums;

public enum code {
    SUCCESS,
    FAILED;

    public int getCode() {
        if (this == SUCCESS) {
            return 0;
        } else if (this == FAILED) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        if (this == SUCCESS) {
            return "SUCCESS";
        } else if (this == FAILED) {
            return "FAILED";
        }
        return "UNKNOWN";
    }

    public static code fromCode(int code) {
        if (code == 0) {
            return SUCCESS;
        } else if (code == 1) {
            return FAILED;
        }
        return null;
    }
}
