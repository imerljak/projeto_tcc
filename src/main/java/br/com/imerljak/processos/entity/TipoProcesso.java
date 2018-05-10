
package br.com.imerljak.processos.entity;

import br.com.imerljak.common.entity.Tipo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("PROCESSO")
public class TipoProcesso extends Tipo {

}