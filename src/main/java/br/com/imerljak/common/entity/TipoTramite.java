package br.com.imerljak.common.entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@DiscriminatorValue("TRAMITE")
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TipoTramite extends Tipo {
    private static final long serialVersionUID = -7549050569633749659L;

    @Builder
    public TipoTramite(@NotNull String nome, String descricao) {
        super(nome, descricao);
    }
}