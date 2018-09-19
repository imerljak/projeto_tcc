
package br.com.imerljak.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorColumn
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Anexo extends Arquivo {
    private static final long serialVersionUID = -1892835440758935271L;
}