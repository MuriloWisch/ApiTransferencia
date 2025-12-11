package MuriloWisch.Dev.ApiTransferencia.repository;

import MuriloWisch.Dev.ApiTransferencia.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferenciaRepository extends JpaRepository<Transferencia,UUID> {

}
