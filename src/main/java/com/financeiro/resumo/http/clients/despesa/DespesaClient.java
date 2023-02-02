package com.financeiro.resumo.http.clients.despesa;

import com.financeiro.resumo.http.models.DespesaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("despesa-ms")
public interface DespesaClient {

    @RequestMapping(method = RequestMethod.GET, value = "/despesas/{ano}/{mes}")
    List<DespesaResponse> buscarPorMesEAno(@PathVariable String ano, @PathVariable String mes);

}
