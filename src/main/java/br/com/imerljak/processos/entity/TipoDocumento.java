
package br.com.imerljak.processos.entity;

import br.com.imerljak.common.entity.Tipo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("DOCUMENTO")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TipoDocumento extends Tipo {
    private static final long serialVersionUID = 1663710071527886322L;
}