
package br.com.imerljak.common.entity;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@MappedSuperclass
public class SoftDeleteEntity extends TimedEntity {

    private static final long serialVersionUID = 1L;

    @Basic
    private boolean removido;

    public boolean isRemovido() {
        return removido;
    }

    public void setRemovido(boolean removido) {
        this.removido = removido;
    }

}