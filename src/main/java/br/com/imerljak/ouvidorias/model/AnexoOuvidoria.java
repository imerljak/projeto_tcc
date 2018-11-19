package br.com.imerljak.ouvidorias.model;

import br.com.imerljak.shared.model.Anexo;
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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(DTypes.Anexo.OUVIDORIA)
public class AnexoOuvidoria extends Anexo {

    private static final long serialVersionUID = 6356713240105726798L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ouvidoria ouvidoria;

}