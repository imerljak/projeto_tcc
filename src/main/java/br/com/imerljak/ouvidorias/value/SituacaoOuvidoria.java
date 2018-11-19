package br.com.imerljak.ouvidorias.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoOuvidoria {
    AGUARDANDO("Aguardando"),
    EM_ANALISE("Em Análise"),
    NAO_CONFIRMADA("Não Confirmada"),
    CORFIRMADA("Confirmada"),
    REDUNDANTE("Redundante"),
    REVOGADA("Revogada"),
    AGUARDANDO_CONCESSIONARIA("Aguardando Concessionária"),
    GEROU_PROCESSO("Gerou Processo"),
    RESOLVIDO("Resolvido");

    private final String descricao;
    public static final SituacaoOuvidoria[] values = values();
}
