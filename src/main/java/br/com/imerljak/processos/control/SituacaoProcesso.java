package br.com.imerljak.processos.control;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoProcesso {
    EM_ANDAMENTO("Em andamento"),
    ARQUIVADO("Arquivado");

    private final String descricao;
}
