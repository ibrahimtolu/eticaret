package com.uniyaz.eticaret.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TokenType {
    BEARER;

    @Override
    public String toString() {
        return "TokenType{}";
    }
}
