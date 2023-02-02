package com.financeiro.resumo.http.models;

import java.math.BigDecimal;

public class ReceitaResponse {
    private BigDecimal valor;
    private String data;

    public BigDecimal getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }
}
