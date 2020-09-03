package com.github.gustavolara.ifmt.cobrancaifmt.controller;

import com.github.gustavolara.ifmt.cobrancaifmt.model.Status;
import com.github.gustavolara.ifmt.cobrancaifmt.model.Titulo;
import com.github.gustavolara.ifmt.cobrancaifmt.model.TituloDTO;
import com.github.gustavolara.ifmt.cobrancaifmt.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pagina/titulos/novo")
public class NovoTituloController {

    @Autowired
    TituloRepository tituloRepository;

    @GetMapping
    public ModelAndView paginaNovoTitulo(){
        ModelAndView mv = new ModelAndView("novo-titulo");
        mv.addObject(Status.values());
        return mv;
    }

    @PostMapping
    public ModelAndView insertTitulo(TituloDTO tituloDTO){
        Titulo titulo = new Titulo();
        titulo.setDescricao(tituloDTO.getDescricao());
        titulo.setDataVencimento(tituloDTO.getDataVencimento());
        titulo.setStatus(tituloDTO.getStatus());
        titulo.setValor(tituloDTO.getValor());
        ModelAndView mv = new ModelAndView("novo-titulo");
        try{
            tituloRepository.save(titulo);
            mv.addObject("sucesso", "sucesso");
        } catch (Exception ex){
            mv.addObject("sucesso", "");
        }
        return mv;
    }
}
