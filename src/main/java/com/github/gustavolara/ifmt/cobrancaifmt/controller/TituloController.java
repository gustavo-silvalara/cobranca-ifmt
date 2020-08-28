package com.github.gustavolara.ifmt.cobrancaifmt.controller;

import com.github.gustavolara.ifmt.cobrancaifmt.model.Titulo;
import com.github.gustavolara.ifmt.cobrancaifmt.model.TituloDTO;
import com.github.gustavolara.ifmt.cobrancaifmt.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/titulos/novo")
public class TituloController {

    @Autowired
    TituloRepository tituloRepository;

    @GetMapping
    public String paginaNovoTitulo(){
        return "novo-titulo";
    }

    @PostMapping
    public String insertTitulo(TituloDTO tituloDTO){
        Titulo titulo = new Titulo();
        titulo.setDescricao(tituloDTO.getDescricao());
        titulo.setDataVencimento(tituloDTO.getDataVencimento());
        titulo.setStatus(tituloDTO.getStatus());
        titulo.setValor(tituloDTO.getValor());
        tituloRepository.save(titulo);
        return "novo-titulo";
    }
}
