
package br.com.imerljak.share.entity;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn
public abstract class Anexo extends Arquivo {
    private static final long serialVersionUID = -1892835440758935271L;
}