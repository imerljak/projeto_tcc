
package br.com.imerljak.common.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn
//@SQLDelete(sql = "UPDATE anexo SET removido = 1 WHERE id = ? AND version = ?")
//@SQLDeleteAll(sql = "UPDATE anexo SET removido = 1")
//@Where(clause = "removido = 0")
public abstract class Anexo extends Arquivo {
    private static final long serialVersionUID = -1892835440758935271L;
}