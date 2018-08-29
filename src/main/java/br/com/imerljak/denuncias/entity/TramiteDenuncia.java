
package br.com.imerljak.denuncias.entity;

import br.com.imerljak.share.entity.Tramite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("DENUNCIA")
public class TramiteDenuncia extends Tramite {

    private static final long serialVersionUID = -8992231396345480007L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Denuncia denuncia;

    public Denuncia getDenuncia() {
        return this.denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

}