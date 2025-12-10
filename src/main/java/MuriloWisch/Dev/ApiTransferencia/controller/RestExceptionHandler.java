package MuriloWisch.Dev.ApiTransferencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import MuriloWisch.Dev.ApiTransferencia.exception.TransferenciaException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TransferenciaException.class)
    public ProblemDetail handleTransferenciaException(TransferenciaException e){
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        var fieldErrors = e.getFieldErrors().stream().map(f -> new InvalidParam(f.getField(),f.getDefaultMessage())).toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("O seu paramatro não é válido");
        pb.setProperty("Parametros invalidos", fieldErrors);

        return pb;
    }
    private record InvalidParam(String name, String reason){

    }
}
