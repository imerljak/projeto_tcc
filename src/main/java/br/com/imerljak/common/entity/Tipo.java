
package br.com.imerljak.common.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn
//@SQLDelete(sql = "UPDATE tipo SET removido=1 WHERE id=? AND version=?")
//@SQLDeleteAll(sql = "UPDATE tipo SET removido=1 WHERE id=? AND version=?")
//@Where(clause = "removido = 0")
public abstract class Tipo extends SimpleEntity {

    private static final long serialVersionUID = 6330763506497934608L;

    @Column(unique = true, nullable = false)
    @Basic
    @NotNull
    private String nome;

    @Basic
    private String descricao;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}