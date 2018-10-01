package br.com.imerljak.denuncias.control;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoDenuncia {
    AGUARDANDO("Aguardando"),
    EM_ANALISE("Em Análise"),
    NAO_CONFIRMADA("Não Confirmada"),
    CORFIRMADA("Confirmada"),
    REDUNDANTE("Redundante"),
    AGUARDANDO_CONCESSIONARIA("Aguardando Concessionária"),
    GEROU_PROCESSO("Gerou Processo"),
    RESOLVIDO("Resolvido");

    private final String descricao;
}
