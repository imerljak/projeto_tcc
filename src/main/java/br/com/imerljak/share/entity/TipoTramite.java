
package br.com.imerljak.share.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorValue("TRAMITE")
public class TipoTramite extends Tipo {
    private static final long serialVersionUID = -7549050569633749659L;
}