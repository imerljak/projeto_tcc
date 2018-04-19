/**
 * This file was generated by the Jeddict
 */
package br.com.imerljak.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn(length = 31)
public abstract class Tipo extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Basic
    @FormParam("nome")
    @NotNull
    private String nome;

    @Basic
    @FormParam("descricao")
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