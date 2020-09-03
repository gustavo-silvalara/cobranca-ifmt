package com.github.gustavolara.ifmt.cobrancaifmt.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Titulo {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVencimento;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private Status status;
}
