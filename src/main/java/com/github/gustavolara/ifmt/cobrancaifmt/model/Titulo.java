package com.github.gustavolara.ifmt.cobrancaifmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Titulo {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String descricao;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;
    @NumberFormat(pattern="#,##0.00")
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private Status status;

    public boolean isPendente(){ return Status.PENDENTE.equals(this.status);}

    public Titulo(TituloDTO tituloDTO){
        descricao = tituloDTO.getDescricao();
        dataVencimento = tituloDTO.getDataVencimento();
        status = tituloDTO.getStatus();
        valor = tituloDTO.getValor();
    }
}
