package com.github.gustavolara.ifmt.cobrancaifmt.repository;

import com.github.gustavolara.ifmt.cobrancaifmt.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "titulos", path = "titulos")
public interface TituloRepository extends JpaRepository<Titulo, Long> {

    List<Titulo> findAllByDataVencimentoBetween(@Param("dataVencimentoIni") Date dataVencimentoIni, @Param("dataVencimentoFim") Date dataVencimentoFim);

    List<Titulo> findAllByDescricaoContains(@Param("descricao") String descricao);
}
