package MuriloWisch.Dev.ApiTransferencia.controller.dto;

import MuriloWisch.Dev.ApiTransferencia.entity.Carteira;
import MuriloWisch.Dev.ApiTransferencia.entity.CarteiraTipo;

public record CriarCarteiraDto(String nomeCompleto, String cpfCnpj, String email, String senha, CarteiraTipo.Enum carteiraTipo) {

    public Carteira toCarteira(){
        return new Carteira(nomeCompleto,cpfCnpj,email,senha,carteiraTipo.get());
    }

}