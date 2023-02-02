package com.financeiro.resumo.http.models;

import java.math.BigDecimal;

public class DespesaResponse {
    private BigDecimal valor;
    private String data;
    private Categoria categoria;

    public BigDecimal getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
