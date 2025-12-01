package MuriloWisch.Dev.ApiTransferencia.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_carteira")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String cpfCnpj;

    private String email;

    private String senha;

    private BigDecimal saldo;

}
