package MuriloWisch.Dev.ApiTransferencia.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "carteira_remetente_id")
    private Carteira remetente;

    @ManyToOne
    @JoinColumn(name = "carteira_recebedor_id")
    private Carteira recebedor;

    @Column(name = "valor")
    private BigDecimal valor;

    public Transferencia() {
    }

}
