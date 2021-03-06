package br.com.imerljak.shared.model;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.time.LocalDateTime;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString(callSuper = true, of = {"nome", "caminho"})
@EqualsAndHashCode(callSuper = true, of = {"nome", "caminho"})
public class Arquivo extends BasicEntity {

    private static final long serialVersionUID = 3950662525028096532L;

    @NotNull
    @Column(nullable = false, length = 191)
    private String nome;

    @Basic
    @NotNull
    @Column(nullable = false, length = 191)
    private String caminho;

    @Basic
    @Column(length = 5)
    private String extencao;

    @LastModifiedDate
    private LocalDateTime dataUltimaAtualizacao;

    public File asFile() {
        return new File(caminho + nome);
    }
}