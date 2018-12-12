package br.com.imerljak.shared.model;

import lombok.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorColumn
@ToString(callSuper = true, of = {})
@EqualsAndHashCode(callSuper = true, of = {})
public abstract class Anexo extends Arquivo {
    private static final long serialVersionUID = -1892835440758935271L;
}