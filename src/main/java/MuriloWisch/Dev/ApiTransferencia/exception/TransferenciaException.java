package MuriloWisch.Dev.ApiTransferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TrasnsferenciaException extends RuntimeException{

    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Transferencia internal server error");

        return pb;
    }
}
