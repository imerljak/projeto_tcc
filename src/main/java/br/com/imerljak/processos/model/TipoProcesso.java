package br.com.imerljak.processos.model;

import br.com.imerljak.shared.Tipo;
import br.com.imerljak.shared.values.DTypes;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue(DTypes.Tipo.PROCESSO)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TipoProcesso extends Tipo {
    private static final long serialVersionUID = -3717858585377329684L;

    @Builder
    public TipoProcesso(@NotNull String nome, String descricao) {
        super(nome, descricao);
    }
}