package MuriloWisch.Dev.ApiTransferencia.service;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.TransferenciaDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Transferencia;
import MuriloWisch.Dev.ApiTransferencia.exception.CarteiraNotFoundException;
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

    public Transferencia transferencia(@Valid TransferenciaDto dto) {
        carteiraRepository.findById(dto.remetente()).orElseThrow(() -> new CarteiraNotFoundException(dto.remetente()));


        return null;
    }
}
