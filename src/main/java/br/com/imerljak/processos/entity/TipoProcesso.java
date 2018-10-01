package br.com.imerljak.processos.entity;

import br.com.imerljak.common.entity.Tipo;
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
@DiscriminatorValue("PROCESSO")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TipoProcesso extends Tipo {
    private static final long serialVersionUID = -3717858585377329684L;

    @Builder
    public TipoProcesso(@NotNull String nome, String descricao) {
        super(nome, descricao);
    }
}