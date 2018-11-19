package br.com.imerljak.shared.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorColumn
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Pessoa extends BasicEntity {

    private static final long serialVersionUID = -1231437318555494389L;

    @Basic
    @NotEmpty
    private String nome;

    @Basic
    @Email
    @NotNull
    private String email;

    @Basic
    private String telefone;

}