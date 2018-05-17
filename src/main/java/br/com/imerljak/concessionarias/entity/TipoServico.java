
package br.com.imerljak.concessionarias.entity;

import br.com.imerljak.common.entity.Tipo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("SERVICO")
public class TipoServico extends Tipo {
    private static final long serialVersionUID = -3842169586249674080L;
}