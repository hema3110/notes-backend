package org.notes.exception;

import org.notes.response.ResponseBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ResponseBase> handleEntityNotFound(EntityNotFoundException entityNotFoundException) {
        List<String> messages = new ArrayList<>();
        messages.add(entityNotFoundException.getMessage());
        ResponseBase responseBase = ResponseBase.builder().messages(messages).isValid(false).build();
        return new ResponseEntity<ResponseBase>(responseBase, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBase> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> messages = new ArrayList<>();
        for (FieldError fe: ex.getFieldErrors()) {
            messages.add(fe.getDefaultMessage());
        }
//        List<String> messages = ex.getFieldErrors().stream().map(fe -> fe.)
        ResponseBase responseBase = ResponseBase.builder().isValid(false).messages(messages).build();
        return new ResponseEntity<ResponseBase>(responseBase, HttpStatus.BAD_REQUEST);
    }
}
