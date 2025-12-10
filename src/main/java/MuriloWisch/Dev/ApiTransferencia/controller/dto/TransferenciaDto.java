package MuriloWisch.Dev.ApiTransferencia.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferenciaDto(@DecimalMin("0.01") BigDecimal valor, @NotNull Long remetente,@NotNull Long recebedor) {

}
