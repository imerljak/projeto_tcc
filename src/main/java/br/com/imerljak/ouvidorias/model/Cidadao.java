package br.com.imerljak.ouvidorias.model;

import br.com.imerljak.shared.values.DTypes;
import br.com.imerljak.vendor.jpa.converter.DocumentoJpaConverter;
import br.com.imerljak.vendor.jpa.annotation.DocumentoValido;
import br.com.imerljak.ouvidorias.value.TipoDocumentoPessoa;
import br.com.imerljak.shared.model.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true,
        exclude = {"ouvidoria"})
@EqualsAndHashCode(callSuper = true,
        exclude = {"ouvidoria"})
@DiscriminatorValue(DTypes.Pessoa.CIDADAO)
@DocumentoValido
public class Cidadao extends Pessoa {

    private static final long serialVersionUID = 1238412128962205476L;

    @Basic
    @NotNull
    @Convert(converter = DocumentoJpaConverter.class)
    private String documento;

    @NotNull
    private TipoDocumentoPessoa tipoDocumento;

    @NotNull
    private String endereco;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cidadao", optional = false)
    private Ouvidoria ouvidoria;
}