package MuriloWisch.Dev.ApiTransferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraDataAlreadyExistsException extends TrasnsferenciaException {

    private String detail;

    public CarteiraDataAlreadyExistsException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Carteira data ja existe");
        pb.setDetail(detail);

        return pb;
    }
}
