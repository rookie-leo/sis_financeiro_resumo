package com.financeiro.resumo.service;

import com.financeiro.resumo.http.clients.despesa.DespesaClient;
import com.financeiro.resumo.http.clients.receita.ReceitaClient;
import com.financeiro.resumo.http.models.DespesaResponse;
import com.financeiro.resumo.http.models.ReceitaResponse;
import com.financeiro.resumo.http.models.Resumo;
import com.financeiro.resumo.http.models.TotalPorCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ResumoService {

    private ReceitaClient receita;
    private DespesaClient despesa;

    @Autowired
    public ResumoService(ReceitaClient receita, DespesaClient despesa) {
        this.receita = receita;
        this.despesa = despesa;
    }

    public Resumo resumo(String ano, String mes) {
        var receitaResponses = receita.listarPorMesEAno(ano, mes);
        var despesaResponses = despesa.buscarPorMesEAno(ano, mes);
        var valorTotalReceitasMes = valorTotalReceitasMes(receitaResponses);
        var valorTotalDespesasMes = valorTotalDespesasMes(despesaResponses);
        var saldoFinalMes = saldoFinalMes(valorTotalReceitasMes, valorTotalDespesasMes);
        var totalPorCategoria = valorTotalGastoMesPorCategoria(despesaResponses);

        return new Resumo(valorTotalReceitasMes, valorTotalDespesasMes, saldoFinalMes, totalPorCategoria);
    }

    private TotalPorCategoria valorTotalGastoMesPorCategoria(List<DespesaResponse> despesaResponses) {
        TotalPorCategoria totalPorCategoria = new TotalPorCategoria();
        despesaResponses.forEach(despesa ->
                totalPorCategoria.calculadoraCategoria(despesa.getCategoria(), despesa.getValor())
                );
        return totalPorCategoria;
    }

    private BigDecimal saldoFinalMes(BigDecimal valorTotalReceitasMes, BigDecimal valorTotalDespesasMes) {
        return valorTotalReceitasMes.subtract(valorTotalDespesasMes);
    }

    private static BigDecimal valorTotalReceitasMes(List<ReceitaResponse> receitaResponses) {
        BigDecimal soma = BigDecimal.ZERO;

        for (ReceitaResponse response : receitaResponses) {
            soma = soma.add(response.getValor());
        }

        return soma;
    }

    private static BigDecimal valorTotalDespesasMes(List<DespesaResponse> despesaResponses) {
        BigDecimal soma = BigDecimal.ZERO;

        for (DespesaResponse despesa : despesaResponses) {
            soma = soma.add(despesa.getValor());
        }

        return soma;
    }
}
