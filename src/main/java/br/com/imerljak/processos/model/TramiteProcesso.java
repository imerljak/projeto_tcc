package br.com.imerljak.processos.model;

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
@DiscriminatorValue(DTypes.Tramite.PROCESSO)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TramiteProcesso extends Tramite {

    private static final long serialVersionUID = -7975509486366489673L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Processo processo;
}