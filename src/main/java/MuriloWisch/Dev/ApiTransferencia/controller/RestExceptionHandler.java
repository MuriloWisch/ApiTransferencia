package MuriloWisch.Dev.ApiTransferencia.controller;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import MuriloWisch.Dev.ApiTransferencia.exception.TransferenciaException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TransferenciaException.class)
    public ProblemDetail handleTransferenciaException(TransferenciaException e){
        return e.toProblemDetail();
    }
}
