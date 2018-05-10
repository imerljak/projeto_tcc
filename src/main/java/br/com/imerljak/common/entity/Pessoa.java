
package br.com.imerljak.common.entity;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn(length = 31, name = "DTYPE")
public abstract class Pessoa extends BaseEntity {

    @Basic
    @NotNull
    private String nome;

    @Basic
    @Email
    private String email;

    @Basic
    private String telefone;

    public Optional<String> getNome() {
        return Optional.ofNullable(this.nome);
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

}