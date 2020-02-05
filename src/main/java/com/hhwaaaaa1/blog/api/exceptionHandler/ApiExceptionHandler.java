package com.hhwaaaaa1.blog.api.exceptionHandler;

import com.hhwaaaaa1.blog.api.exception.ApiException;
import com.hhwaaaaa1.blog.api.exception.mapper.ApiExceptionMapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = {ApiExceptionMapper.class})
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public void exception(){
    }
}
