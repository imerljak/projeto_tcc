package br.com.imerljak.shared.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Arquivo extends BasicEntity {

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

    @LastModifiedDate
    private LocalDateTime dataUltimaAtualizacao;
}