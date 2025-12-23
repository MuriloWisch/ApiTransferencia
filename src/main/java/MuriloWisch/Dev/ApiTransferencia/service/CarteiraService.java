package MuriloWisch.Dev.ApiTransferencia.service;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.CriarCarteiraDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import MuriloWisch.Dev.ApiTransferencia.exception.CarteiraDataAlreadyExistsException;
import MuriloWisch.Dev.ApiTransferencia.repository.CarteiraRepository;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public CarteiraService(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    public Carteira criarCarteira(CriarCarteiraDto dto) {

        var carteiraDb = carteiraRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(),dto.email());
        if (carteiraDb.isPresent()){
            throw new CarteiraDataAlreadyExistsException("CpfCnpj ou Email ja existe");
        }
        return carteiraRepository.save(dto.toCarteira());
    }



}
