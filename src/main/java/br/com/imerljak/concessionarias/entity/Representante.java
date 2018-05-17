
package br.com.imerljak.concessionarias.entity;

import br.com.imerljak.common.entity.Pessoa;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("REPRESENTANTE")
public class Representante extends Pessoa {

    private static final long serialVersionUID = 5136286368992534275L;

    @Basic
    private String cargo;

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}