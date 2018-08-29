
package br.com.imerljak.share.entity;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn
public abstract class Pessoa extends BaseEntity {

    private static final long serialVersionUID = -1231437318555494389L;

    @Basic
    @NotEmpty
    private String nome;

    @Basic
    @Email
    private String email;

    @Basic
    private String telefone;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}