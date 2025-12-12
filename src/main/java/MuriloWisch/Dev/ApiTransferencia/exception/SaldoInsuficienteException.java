package MuriloWisch.Dev.ApiTransferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SaldoInsuficienteException extends TransferenciaException {
    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Saldo insuficiente");
        pb.setDetail("Você não pode transferir um valor maior que o seu saldo");
        return pb;
    }
}
