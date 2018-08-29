
package br.com.imerljak.processos.entity;

import br.com.imerljak.share.entity.Tramite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("PROCESSO")
public class TramiteProcesso extends Tramite {

    private static final long serialVersionUID = -7975509486366489673L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Processo processo;

    public Processo getProcesso() {
        return this.processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

}