package com.cs.order.controller;

import com.cs.order.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionCOntroller extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {OrderNotFoundException.class})
    protected ResponseEntity<String> handle(
            OrderNotFoundException ex, WebRequest request) {
        String bodyOfResponse = "Order could not be found";
        return new ResponseEntity<String>(bodyOfResponse, HttpStatus.OK);
    }
    @ExceptionHandler(value
            = {Throwable.class})
    protected ResponseEntity<String> handleUnexpectedError(
            OrderNotFoundException ex, WebRequest request) {
        String bodyOfResponse = "Unexpected Error happened";
        log.error("Error occured during prcoessing",ex);
        return new ResponseEntity<String>(bodyOfResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
