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

    public Transferencia(Carteira recebedor, Carteira remetente, BigDecimal valor) {
        this.recebedor = recebedor;
        this.remetente = remetente;
        this.valor = valor;
    }

    public Transferencia() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Carteira getRemetente() {
        return remetente;
    }

    public void setRemetente(Carteira remetente) {
        this.remetente = remetente;
    }

    public Carteira getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Carteira recebedor) {
        this.recebedor = recebedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
