package MuriloWisch.Dev.ApiTransferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferenciaNotAllowedForCarteiraTipoException extends TransferenciaException {


    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Tranfesrencia indisponivel para este tipo de carteira");

        return pb;
    }
}

