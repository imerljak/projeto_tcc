
package br.com.imerljak.common.entity;

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
@DiscriminatorValue("TRAMITE")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AnexoTramite extends Anexo {

    private static final long serialVersionUID = 345447199231481874L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tramite tramite;
}