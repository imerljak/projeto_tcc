
package br.com.imerljak.common.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("TRAMITE")
public class AnexoTramite extends Anexo {

    private static final long serialVersionUID = 345447199231481874L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tramite tramite;

    public Tramite getTramite() {
        return this.tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

}