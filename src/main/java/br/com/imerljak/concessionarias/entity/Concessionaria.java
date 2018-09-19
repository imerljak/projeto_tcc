
package br.com.imerljak.concessionarias.entity;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.imerljak.concessionarias.control.CnpjFormatConverter;
import br.com.imerljak.denuncias.entity.Denuncia;
import br.com.imerljak.common.control.Telefone;
import br.com.imerljak.common.control.TelefoneFormatConverter;
import br.com.imerljak.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true,
        exclude = {"representantes", "denuncias", "servicos"})
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cnpj"}))
public class Concessionaria extends BaseEntity {

    private static final long serialVersionUID = -210267340348887485L;

    @NonNull
    @NotEmpty
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String nome;

    @NonNull
    @NotEmpty
    @CNPJ(formatted = true)
    @Convert(converter = CnpjFormatConverter.class)
    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Basic
    private String endereco;

    @Telefone
    @Convert(converter = TelefoneFormatConverter.class)
    @Column(length = 12, nullable = false)
    private String telefone;

    @Email
    @Column(length = 191)
    private String email;

    @Valid
    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Representante> representantes = new ArrayList<>();

    @OneToMany(mappedBy = "concessionaria")
    private List<Denuncia> denuncias = new ArrayList<>();

    @ManyToMany
    private Set<TipoServico> servicos = new HashSet<>();

}
