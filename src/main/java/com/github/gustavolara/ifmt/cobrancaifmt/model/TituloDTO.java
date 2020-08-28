package com.github.gustavolara.ifmt.cobrancaifmt.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TituloDTO {
    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVencimento;
    private BigDecimal valor;
    private Status status;
}
