package MuriloWisch.Dev.ApiTransferencia.controller;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.CriarCarteiraDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import MuriloWisch.Dev.ApiTransferencia.service.CarteiraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarteiraController {
    private final CarteiraService carteiraService;

    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @PostMapping("/carteira")
    public ResponseEntity<Carteira> criarCarteira(@RequestBody @Valid CriarCarteiraDto dto){

       var carteira = carteiraService.criarCarteira(dto);

       return ResponseEntity.ok(carteira);

    }
}
