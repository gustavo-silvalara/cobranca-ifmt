package com.github.gustavolara.ifmt.cobrancaifmt.service;

import com.github.gustavolara.ifmt.cobrancaifmt.model.Titulo;
import com.github.gustavolara.ifmt.cobrancaifmt.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituloService {

    @Autowired
    TituloRepository tituloRepository;

    public void save(Titulo titulo){
        if(titulo)
    }

}
