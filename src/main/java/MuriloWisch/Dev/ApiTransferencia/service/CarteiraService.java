package MuriloWisch.Dev.ApiTransferencia.service;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.CriarCarteiraDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import MuriloWisch.Dev.ApiTransferencia.exception.CarteiraDataAlreadyExistsException;
import MuriloWisch.Dev.ApiTransferencia.exception.CarteiraNotFoundException;
import MuriloWisch.Dev.ApiTransferencia.exception.SaldoInsuficienteException;
import MuriloWisch.Dev.ApiTransferencia.repository.CarteiraRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public Carteira criarCarteira(CriarCarteiraDto dto) {

        var carteiraDb = carteiraRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(),dto.email());
        if (carteiraDb.isPresent()){
            throw new CarteiraDataAlreadyExistsException("CpfCnpj ou Email ja existe.");
        }
        return carteiraRepository.save(dto.toCarteira());
    }


    public void creditarSaldo(Long id, BigDecimal novoSaldo) {

        if (novoSaldo.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Não é permitido creditar um valor menor que 0.");
        }

        int linhasAfetadas = carteiraRepository.creditarSaldo(id, novoSaldo);

        if (linhasAfetadas == 0){
            throw new CarteiraNotFoundException(id);
        }

    }
}
