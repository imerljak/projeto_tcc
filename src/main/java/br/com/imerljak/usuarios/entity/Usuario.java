
package br.com.imerljak.usuarios.entity;

import br.com.imerljak.processos.entity.Processo;
import br.com.imerljak.share.entity.BaseEntity;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
public class Usuario extends BaseEntity {

    private static final long serialVersionUID = 3391331287260381725L;

    @Basic
    @NotEmpty
    @Column(name = "nome", nullable = false)
    private String nome;

    @Email
    @NotEmpty
    @Column(name = "email", nullable = false)
    @Basic(optional = false)
    private String email;

    @NotEmpty
    @Size(min = 6, message = "A senha deve ter mais que 6 caracteres")
    @Basic(optional = false)
    private String senha;

    @OneToMany(mappedBy = "relator")
    private Set<Processo> processosRelator = new HashSet<>();

    @OneToMany(mappedBy = "revisor")
    private Set<Processo> processosRevisor = new HashSet<>();

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

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Processo> getProcessosRelator() {
        return this.processosRelator;
    }

    public void setProcessosRelator(Set<Processo> processosRelator) {
        this.processosRelator = processosRelator;
    }

    public void addProcessosRelator(Processo processosRelator) {
        getProcessosRelator().add(processosRelator);
        processosRelator.setRelator(this);
    }

    public void removeProcessosRelator(Processo processosRelator) {
        getProcessosRelator().remove(processosRelator);
        processosRelator.setRelator(null);
    }

    public Set<Processo> getProcessosRevisor() {
        return this.processosRevisor;
    }

    public void setProcessosRevisor(Set<Processo> processosRevisor) {
        this.processosRevisor = processosRevisor;
    }

    public void addProcessosRevisor(Processo processosRevisor) {
        getProcessosRevisor().add(processosRevisor);
        processosRevisor.setRevisor(this);
    }

    public void removeProcessosRevisor(Processo processosRevisor) {
        getProcessosRevisor().remove(processosRevisor);
        processosRevisor.setRevisor(null);
    }
}