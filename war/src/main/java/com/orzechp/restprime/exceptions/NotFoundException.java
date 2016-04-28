package com.orzechp.restprime.exceptions;

public class NotFoundException extends RuntimeException {
    private final String response;

    public NotFoundException(String response) {
        super(response);
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
