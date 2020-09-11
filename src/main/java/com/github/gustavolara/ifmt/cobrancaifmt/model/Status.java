package com.github.gustavolara.ifmt.cobrancaifmt.model;

public enum Status {
    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
