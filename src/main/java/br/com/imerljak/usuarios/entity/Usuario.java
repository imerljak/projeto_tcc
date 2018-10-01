package br.com.imerljak.usuarios.entity;

import br.com.imerljak.common.entity.AuditableEntity;
import br.com.imerljak.processos.entity.Processo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
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
@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true,
        exclude = {"cargos", "processosRelator", "processosRevisor"})
@EqualsAndHashCode(callSuper = true,
        exclude = {"cargos", "processosRelator", "processosRevisor"})
public class Usuario extends AuditableEntity {

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

    @JsonIgnore
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

    @Valid
    @NotEmpty
    @OrderBy("nivel")
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "usuario_cargo")
    private Set<Cargo> cargos = new HashSet<>();
}