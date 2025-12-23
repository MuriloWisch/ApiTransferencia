package MuriloWisch.Dev.ApiTransferencia.controller.dto;

import java.math.BigDecimal;

public class AtualizarSaldoDto {
    private BigDecimal saldo;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
