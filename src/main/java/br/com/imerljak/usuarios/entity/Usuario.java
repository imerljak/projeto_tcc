
package br.com.imerljak.usuarios.entity;

import br.com.imerljak.processos.entity.Processo;
import br.com.imerljak.share.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @Size(min = 6, message = "A senha deve ter mais que 6 caracteres")
    @Basic(optional = false)
    private String senha;

    @Basic
    @Column(nullable = false)
    private boolean ativo = true;

    @OneToMany(mappedBy = "relator")
    private List<Processo> processosRelator = new ArrayList<>();

    @OneToMany(mappedBy = "revisor")
    private List<Processo> processosRevisor = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "usuario_role")
    private Set<Role> roles = new HashSet<>();

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

    public List<Processo> getProcessosRelator() {
        return new ArrayList<>(this.processosRelator);
    }

    public void addProcessosRelator(Processo processosRelator) {
        this.processosRelator.add(processosRelator);
        processosRelator.setRelator(this);
    }

    public void removeProcessosRelator(Processo processosRelator) {
        this.processosRelator.remove(processosRelator);
        processosRelator.setRelator(null);
    }

    public List<Processo> getProcessosRevisor() {
        return new ArrayList<>(this.processosRevisor);
    }

    public void addProcessosRevisor(Processo processosRevisor) {
        this.processosRevisor.add(processosRevisor);
        processosRevisor.setRevisor(this);
    }

    public void removeProcessosRevisor(Processo processosRevisor) {
        this.processosRevisor.remove(processosRevisor);
        processosRevisor.setRevisor(null);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}