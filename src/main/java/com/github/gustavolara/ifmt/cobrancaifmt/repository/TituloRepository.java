package com.github.gustavolara.ifmt.cobrancaifmt.repository;

import com.github.gustavolara.ifmt.cobrancaifmt.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {

}
