
package br.com.imerljak.share.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@MappedSuperclass
public class Arquivo extends BaseEntity {

    private static final long serialVersionUID = 1L;

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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return this.caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getExtencao() {
        return this.extencao;
    }

    public void setExtencao(String extencao) {
        this.extencao = extencao;
    }

}