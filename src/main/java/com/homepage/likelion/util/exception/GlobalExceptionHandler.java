package com.homepage.likelion.util.exception;

import com.homepage.likelion.util.response.CustomApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomApiResponse<?>> handleGlobalExceptionHandler(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(": "));

        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CustomApiResponse.createFailWithout(HttpStatus.BAD_REQUEST.value(), errorMessage));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomApiResponse<?>> handleConstraintViolationException(ConstraintViolationException e){
                String errorMessage = e.getErrorMessage();

        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(CustomApiResponse.createFailWithout(HttpStatus.BAD_REQUEST.value(), errorMessage));
    }
}
