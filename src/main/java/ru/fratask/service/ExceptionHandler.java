package ru.fratask.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.fratask.model.AppError;
import ru.fratask.model.AppException;
import ru.fratask.model.AppResponseCode;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<AppError> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AppError(AppResponseCode.UNKNOWN.getCode(), ex.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<AppError> handleAppException(AppException ex) {
        return ResponseEntity.ok(new AppError(ex.getCode().getCode(), ex.getMessage()));
    }
}
