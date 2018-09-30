package br.com.imerljak.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorColumn
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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

}