package br.com.imerljak.concessionarias.entity;

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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("SERVICO")
public class TipoServico extends Tipo {
    private static final long serialVersionUID = -3842169586249674080L;

    @Builder
    public TipoServico(@NotNull String nome, String descricao) {
        super(nome, descricao);
    }
}