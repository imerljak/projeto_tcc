
package br.com.imerljak.common.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

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
@DiscriminatorColumn
//@SQLDelete(sql = "UPDATE pessoa SET removido = 1 WHERE id = ? AND version = ?")
//@SQLDeleteAll(sql = "UPDATE pessoa SET removido = 1")
//@Where(clause = "removido = 0")
public abstract class Pessoa extends SoftDeleteEntity {

    private static final long serialVersionUID = -1231437318555494389L;

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