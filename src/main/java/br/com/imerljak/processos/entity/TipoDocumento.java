
package br.com.imerljak.processos.entity;

import br.com.imerljak.share.entity.Tipo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("DOCUMENTO")
public class TipoDocumento extends Tipo {
    private static final long serialVersionUID = 1663710071527886322L;
}