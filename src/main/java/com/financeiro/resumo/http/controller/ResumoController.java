package com.financeiro.resumo.http.controller;

import com.financeiro.resumo.http.models.Resumo;
import com.financeiro.resumo.service.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumo")
public class ResumoController {

    private ResumoService service;

    @Autowired
    public ResumoController(ResumoService service) {
        this.service = service;
    }

    @GetMapping("/{ano}/{mes}")
    public Resumo resumo(@PathVariable String ano, @PathVariable String mes) {
        return service.resumo(ano, mes);
    }

}
