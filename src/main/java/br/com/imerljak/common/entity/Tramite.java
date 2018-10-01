package br.com.imerljak.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorColumn
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Tramite extends AuditableEntity {

    private static final long serialVersionUID = 8695715051300957310L;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoTramite tipoTramite;

}