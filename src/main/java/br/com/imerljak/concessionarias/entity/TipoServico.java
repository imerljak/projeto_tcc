
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

}