package org.api.springbootrestapimongodb.resources.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.api.springbootrestapimongodb.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);

    }
}
