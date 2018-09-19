
package br.com.imerljak.denuncias.entity;

import br.com.imerljak.common.entity.Tramite;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("DENUNCIA")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TramiteDenuncia extends Tramite {

    private static final long serialVersionUID = -8992231396345480007L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Denuncia denuncia;
}