package br.com.imerljak.ouvidorias.value;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoOuvidoria {
    DENUNCIA("Denuncia", "table-danger"),
    RECLAMACAO("Reclamação", "table-warning"),
    ELOGIO("Elogio", "table-success"),
    SUGESTAO("Sugestão", "table-info");

    @JsonValue
    private final String descricao;
    private final String contextClass;

    public static final TipoOuvidoria[] VALUES = values();

}
