package br.com.imerljak.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@MappedSuperclass
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Arquivo extends BaseEntity {

    private static final long serialVersionUID = 3950662525028096532L;

    @NotNull
    @Column(unique = true, nullable = false, length = 191)
    private String nome;

    @Basic
    @NotNull
    @Column(unique = true, nullable = false, length = 191)
    private String caminho;

    @Basic
    @NotNull
    @Column(unique = true, nullable = false, length = 5)
    private String extencao;
}