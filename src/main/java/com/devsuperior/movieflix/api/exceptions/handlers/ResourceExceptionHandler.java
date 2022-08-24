package com.devsuperior.movieflix.api.exceptions.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.devsuperior.movieflix.api.exceptions.StandardError;
import com.devsuperior.movieflix.domain.services.exceptions.NotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> handleNotFoundException(NotFoundException e,
            HttpServletRequest request) {
        return generateStandardError(HttpStatus.NOT_FOUND, e.getClass().getSimpleName(), e.getLocalizedMessage(),
                request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
            HttpServletRequest request) {
        var error = getStandarError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Validation Error", null,
                request.getRequestURI());
        e.getFieldErrors()
                .forEach(fieldError -> error.addValidationError(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    private StandardError getStandarError(Integer status, String error, String message, String path) {
        return new StandardError(status, error, message, path);
    }

    private ResponseEntity<StandardError> generateStandardError(HttpStatus status, String error, String message,
            String path) {
        var err = getStandarError(status.value(), error, message, path);
        return ResponseEntity.status(status).body(err);
    }

}
