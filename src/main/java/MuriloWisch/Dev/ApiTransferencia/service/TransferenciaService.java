package MuriloWisch.Dev.ApiTransferencia.service;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.TransferenciaDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import MuriloWisch.Dev.ApiTransferencia.entity.Transferencia;
import MuriloWisch.Dev.ApiTransferencia.exception.CarteiraNotFoundException;
import MuriloWisch.Dev.ApiTransferencia.exception.TransferenciaException;
import MuriloWisch.Dev.ApiTransferencia.exception.TransferenciaNotAllowedForCarteiraTipoException;
import MuriloWisch.Dev.ApiTransferencia.repository.CarteiraRepository;
import MuriloWisch.Dev.ApiTransferencia.repository.TransferenciaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final CarteiraRepository carteiraRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, CarteiraRepository carteiraRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.carteiraRepository = carteiraRepository;
    }

    public Transferencia transferencia(TransferenciaDto transferenciaDto) {
        var pagador = carteiraRepository.findById(transferenciaDto.remetente()).orElseThrow(() -> new CarteiraNotFoundException(transferenciaDto.remetente()));
        var recebedor = carteiraRepository.findById(transferenciaDto.recebedor()).orElseThrow(() -> new CarteiraNotFoundException(transferenciaDto.recebedor()));

        validarTransferencia(transferenciaDto, pagador);


        return null;
    }

    private void validarTransferencia(TransferenciaDto transferenciaDto, Carteira pagador) {
        if (!pagador.isTransferenciaAllowedForCarteiraTipo()){
            throw new TransferenciaNotAllowedForCarteiraTipoException();
        }

        if (!pagador.isBalanceBiggerThan(transferenciaDto.valor())){

        }
    }
}
