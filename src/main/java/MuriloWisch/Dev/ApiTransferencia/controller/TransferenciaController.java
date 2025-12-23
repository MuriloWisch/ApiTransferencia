package MuriloWisch.Dev.ApiTransferencia.controller;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.TransferenciaDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Transferencia;
import MuriloWisch.Dev.ApiTransferencia.service.TransferenciaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferenciaController {

    private TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Transferencia> transferencia(@RequestBody @Valid TransferenciaDto dto){
        var response = transferenciaService.transferencia(dto);

        return ResponseEntity.ok(response);
    }
}
