package com.luizmrd.handler;

import com.luizmrd.exception.BadRequestException;
import com.luizmrd.exception.ErrorResponse;
import com.luizmrd.exception.ResourceNotFoundExeption;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handlerBadRequest(BadRequestException ex){
        ErrorResponse resp = ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }@ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFound(ResourceNotFoundExeption ex){
        ErrorResponse resp = ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
    }

}
