package MuriloWisch.Dev.ApiTransferencia.repository;

import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import feign.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
    Optional findByCpfCnpjOrEmail(String cpfCnpj, String email);


    @Modifying
    @Transactional
    @Query("UPDATE Carteira c SET c.saldo = :saldo WHERE c.id = :id")
    void atualizarSaldo(@Param ("id") Long id, @Param("saldo")BigDecimal saldo);
}
