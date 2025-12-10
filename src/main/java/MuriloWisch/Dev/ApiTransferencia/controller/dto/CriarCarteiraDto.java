package MuriloWisch.Dev.ApiTransferencia.controller.dto;

import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import MuriloWisch.Dev.ApiTransferencia.entity.CarteiraTipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarCarteiraDto(@NotBlank String nomeCompleto,@NotBlank String cpfCnpj,@NotBlank String email,@NotBlank String senha,@NotNull CarteiraTipo.Enum carteiraTipo) {

    public Carteira toCarteira(){
        return new Carteira(nomeCompleto,cpfCnpj,email,senha,carteiraTipo.get());
    }

}