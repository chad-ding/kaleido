package com.xiyou.kaleido.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.xiyou.kaleido.common.annotation.KaleidoController;

/**
 * Created by chad.ding on 2017/1/9.
 */

@ControllerAdvice(annotations = KaleidoController.class)
public class KaleidoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {KaleidoException.class})
    public ResponseEntity<Object> handleKaleidoException(KaleidoException e, WebRequest request){

        ExceptionBody body = new ExceptionBody();
        body.setCode(e.getCode());
        body.setMsg(e.getMessage());
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return handleExceptionInternal(e, body, headers, status, request);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleUncaughtException(Exception e, WebRequest request){

        ExceptionBody body = new ExceptionBody();
        body.setCode(500);
        body.setMsg(e.getMessage());
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return handleExceptionInternal(e, body, headers, status, request);
    }
}
