
package br.com.imerljak.common.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("TRAMITE")
public class TipoTramite extends Tipo {

}