package com.github.gustavolara.ifmt.cobrancaifmt.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Titulo {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private LocalDate dataVencimento;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private Status status;
}
