
package br.com.imerljak.common.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@MappedSuperclass
public class TimedEntity extends SimpleEntity {

    private static final long serialVersionUID = 1L;

    @Column(updatable = false, nullable = false)
    @Basic(optional = false)
//    @NotNull
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    @Basic(optional = false)
//    @NotNull
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

}