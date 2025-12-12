package MuriloWisch.Dev.ApiTransferencia.service;

import MuriloWisch.Dev.ApiTransferencia.controller.dto.TransferenciaDto;
import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import MuriloWisch.Dev.ApiTransferencia.entity.Transferencia;
import MuriloWisch.Dev.ApiTransferencia.exception.CarteiraNotFoundException;
import MuriloWisch.Dev.ApiTransferencia.exception.SaldoInsuficienteException;
import MuriloWisch.Dev.ApiTransferencia.exception.TransferenciaNotAllowedForCarteiraTipoException;
import MuriloWisch.Dev.ApiTransferencia.repository.CarteiraRepository;
import MuriloWisch.Dev.ApiTransferencia.repository.TransferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final CarteiraRepository carteiraRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, CarteiraRepository carteiraRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.carteiraRepository = carteiraRepository;
    }

    @Transactional
    public Transferencia transferencia(TransferenciaDto transferenciaDto) {
        var pagador = carteiraRepository.findById(transferenciaDto.remetente()).orElseThrow(() -> new CarteiraNotFoundException(transferenciaDto.remetente()));
        var recebedor = carteiraRepository.findById(transferenciaDto.recebedor()).orElseThrow(() -> new CarteiraNotFoundException(transferenciaDto.recebedor()));

        validarTransferencia(transferenciaDto, pagador);

        pagador.debitar(transferenciaDto.valor());
        recebedor.creditar(transferenciaDto.valor());

        var transferencia = new Transferencia(pagador,recebedor, transferenciaDto.valor());
        carteiraRepository.save(pagador);
        carteiraRepository.save(recebedor);
        var transferenciaResultado = transferenciaRepository.save(transferencia);

        return transferenciaResultado;
    }

    private void validarTransferencia(TransferenciaDto transferenciaDto, Carteira pagador) {
        if (!pagador.isTransferenciaAllowedForCarteiraTipo()){
            throw new TransferenciaNotAllowedForCarteiraTipoException();
        }

        if (!pagador.isBalanceBiggerThan(transferenciaDto.valor())){
            throw new SaldoInsuficienteException();
        }
    }
}
