package com.in28minutes.rest.webservices.restfulwebservices.exception;

import com.in28minutes.rest.webservices.restfulwebservices.post.PostsNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserBadRequestException;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions
            (Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException
            (UserNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostsNotFoundException.class)
    public final ResponseEntity<Object> handlePostNotFoundException
            (PostsNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserBadRequestException.class)
    public final ResponseEntity<Object> handleUserBadRequestException
            (UserBadRequestException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), "Validation Failied",
                        ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST );    }
}
