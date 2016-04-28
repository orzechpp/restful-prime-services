package com.orzechp.restprime.controllers;

import com.orzechp.restprime.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BaseController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public String responseDataNotFound(NotFoundException exception) {
        return "No Data Found: " + exception.getMessage();
    }
}
