package MuriloWisch.Dev.ApiTransferencia.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraNotFoundException extends TransferenciaException {

    private Long carteiraId;

    public CarteiraNotFoundException(Long carteiraId) {
        this.carteiraId = carteiraId;
    }

    /*Aqui neste trecho é onde detalhamos oque sera retornado no erro*/

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle("Carteira não encontrada");
        pb.setDetail("Não existe carteira com o id" + carteiraId + ".");
    }
}
