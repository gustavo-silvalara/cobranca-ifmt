package com.github.gustavolara.ifmt.cobrancaifmt.controller;

import com.github.gustavolara.ifmt.cobrancaifmt.model.Titulo;
import com.github.gustavolara.ifmt.cobrancaifmt.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("pagina/titulos")
public class TitulosController {

    @Autowired
    TituloRepository tituloRepository;

    @GetMapping()
    public ModelAndView paginaTitulos(@RequestParam(value = "descricao", required = false) String descricao){
        ModelAndView mv = new ModelAndView("titulos");
        mv.addObject("descricao", descricao);
        List<Titulo> tituloList = descricao == null ? tituloRepository.findAll()
                : tituloRepository.findAllByDescricaoContains(descricao);
        mv.addObject("tituloList", tituloList);
        return mv;
    }
}
