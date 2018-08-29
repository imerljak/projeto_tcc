
package br.com.imerljak.denuncias.entity;

import br.com.imerljak.share.entity.Pessoa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("DENUNCIANTE")
public class Denunciante extends Pessoa {

    private static final long serialVersionUID = 1238412128962205476L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Denuncia denuncia;

    public Denuncia getDenuncia() {
        return this.denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

}