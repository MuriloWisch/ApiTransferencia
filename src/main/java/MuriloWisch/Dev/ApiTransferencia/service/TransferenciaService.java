package MuriloWisch.Dev.ApiTransferencia.service;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.TransferenciaDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Transferencia;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {
    public Transferencia transferencia(@Valid TransferenciaDto dto) {

    }
}
