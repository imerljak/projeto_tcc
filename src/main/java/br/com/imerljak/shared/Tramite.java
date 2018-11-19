package br.com.imerljak.shared;

import br.com.imerljak.shared.model.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorColumn
@EntityListeners(AuditingEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Tramite extends BasicEntity {

    private static final long serialVersionUID = 8695715051300957310L;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoTramite tipoTramite;

    @CreatedBy
    @Column(updatable = false)
    private String criadoPor;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime dataCriacao;

}