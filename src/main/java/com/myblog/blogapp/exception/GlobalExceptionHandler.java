package com.myblog.blogapp.exception;

import com.myblog.blogapp.payload.Errordetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Errordetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){

        Errordetails errordetails =new Errordetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
          return  new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Errordetails> handleAllException(Exception exception,
                                                                        WebRequest webRequest){

        Errordetails errordetails =new Errordetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return  new ResponseEntity<>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
