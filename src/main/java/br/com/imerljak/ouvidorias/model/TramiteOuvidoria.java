package br.com.imerljak.ouvidorias.model;

import br.com.imerljak.shared.Tramite;
import br.com.imerljak.shared.values.DTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue(DTypes.Tramite.OUVIDORIA)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TramiteOuvidoria extends Tramite {

    private static final long serialVersionUID = -8992231396345480007L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ouvidoria ouvidoria;
}