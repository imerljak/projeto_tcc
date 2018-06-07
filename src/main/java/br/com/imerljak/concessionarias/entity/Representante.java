
package br.com.imerljak.concessionarias.entity;

import br.com.imerljak.share.entity.Pessoa;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("REPRESENTANTE")
public class Representante extends Pessoa {

    private static final long serialVersionUID = 5136286368992534275L;

    @Basic
    @NotNull
    private String cargo;

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Representante{" +
                super.toString() +
                "cargo='" + cargo + '\'' +
                '}';
    }
}