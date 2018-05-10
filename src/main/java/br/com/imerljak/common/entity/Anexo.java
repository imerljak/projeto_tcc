
package br.com.imerljak.common.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn(length = 31)
public abstract class Anexo extends Arquivo {

}