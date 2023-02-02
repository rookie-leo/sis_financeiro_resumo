package com.financeiro.resumo.http.clients.receita;

import com.financeiro.resumo.http.models.ReceitaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("receita-ms")
public interface ReceitaClient {

    @RequestMapping(method = RequestMethod.GET, value = "/receitas/{ano}/{mes}")
    List<ReceitaResponse> listarPorMesEAno(@PathVariable String ano, @PathVariable String mes);
}
