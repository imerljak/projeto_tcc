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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("DOCUMENTO")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TipoDocumento extends Tipo {
    private static final long serialVersionUID = 1663710071527886322L;

    @Builder
    public TipoDocumento(@NotNull String nome, String descricao) {
        super(nome, descricao);
    }
}