
package br.com.imerljak.common.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    @Basic(optional = false)
    @NotNull
    @PastOrPresent
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    @Basic(optional = false)
    @NotNull
    @PastOrPresent
    private LocalDateTime dataAtualizacao;

    @Basic
    @PastOrPresent
    private LocalDateTime dataRemocao;

    @PrePersist
    protected void prePersist() {
        dataCriacao = LocalDateTime.now();
        dataAtualizacao = dataCriacao;
    }

    @PreRemove
    protected void preRemove() {
        dataRemocao = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDataRemocao() {
        return this.dataRemocao;
    }

    public void setDataRemocao(LocalDateTime dataRemocao) {
        this.dataRemocao = dataRemocao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        if (!java.util.Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.getId());
        return hash;
    }

}