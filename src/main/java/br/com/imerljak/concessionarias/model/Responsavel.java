package br.com.imerljak.concessionarias.model;

import br.com.imerljak.shared.model.Pessoa;
import br.com.imerljak.shared.values.DTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, of = {})
@DiscriminatorValue(DTypes.Pessoa.RESPONSAVEL)
public class Responsavel extends Pessoa {

    private static final long serialVersionUID = 5136286368992534275L;

    @Basic
    @NotEmpty
    private String cargo;
}