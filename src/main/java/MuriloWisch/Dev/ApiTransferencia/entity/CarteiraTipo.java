package MuriloWisch.Dev.ApiTransferencia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_carteira_tipo")
public class CarteiraTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    public CarteiraTipo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public enum Enum {

        USUARIO(1L, "usuario"),
        LOJISTA(2L, "lojista");

        Enum(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;

    }
}
