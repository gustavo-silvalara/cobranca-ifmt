package com.github.gustavolara.ifmt.cobrancaifmt.controller;

import com.github.gustavolara.ifmt.cobrancaifmt.model.Status;
import com.github.gustavolara.ifmt.cobrancaifmt.model.Titulo;
import com.github.gustavolara.ifmt.cobrancaifmt.model.TituloDTO;
import com.github.gustavolara.ifmt.cobrancaifmt.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("pagina/titulos/novo")
public class NovoTituloController {

    @Autowired
    TituloRepository tituloRepository;

    @GetMapping
    public ModelAndView paginaNovoTitulo(@RequestParam(value = "id", required = false, defaultValue = "-1") Long id) {
        ModelAndView mv = new ModelAndView("novo-titulo");
        mv.addObject("statusList", Status.values());
        Optional<Titulo> optionalTitulo = tituloRepository.findById(id);
        Titulo titulo = optionalTitulo.isPresent() ? optionalTitulo.get() : null;
        mv.addObject("titulo", titulo);
        return mv;
    }

    @PostMapping
    public ModelAndView insertTitulo(TituloDTO tituloDTO) {
        Titulo titulo = new Titulo(tituloDTO);
        return saveTituloAndGetModelAndView(titulo);
    }

    @PutMapping("/{id}")
    public ModelAndView updateTitulo(@PathVariable("id") Long id,TituloDTO tituloDTO){
        Titulo titulo = new Titulo(tituloDTO);
        titulo.setId(id);
        return saveTituloAndGetModelAndView(titulo);
    }

    private ModelAndView saveTituloAndGetModelAndView(Titulo titulo) {
        ModelAndView mv = new ModelAndView("novo-titulo");
        mv.addObject("statusList", Status.values());
        var attName = "sucesso";
        try {
            tituloRepository.save(titulo);
            mv.addObject(attName, attName);
        } catch (Exception ex) {
            mv.addObject(attName, "");
        }
        return mv;
    }
}
