package com.mauro.project.helpdesk.resources.exceptions;


import com.mauro.project.helpdesk.services.exceptions.ObjectnotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectnotFoundException.class) // manipulando a exeção da classe ObjectnotFoundException.
    public ResponseEntity<StandardError> objectnotFoundException(ObjectnotFoundException ex, HttpServletRequest request){

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "object Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
