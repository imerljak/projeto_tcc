package br.com.imerljak.common.entity;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorColumn
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Tipo extends BasicEntity {

    private static final long serialVersionUID = 6330763506497934608L;

    @Column(unique = true, nullable = false)
    @Basic
    @NotNull
    @NonNull
    private String nome;

    @Basic
    private String descricao;

}