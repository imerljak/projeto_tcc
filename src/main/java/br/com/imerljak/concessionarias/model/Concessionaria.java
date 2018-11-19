package br.com.imerljak.concessionarias.model;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.shared.model.BasicEntity;
import br.com.imerljak.vendor.jpa.annotation.Telefone;
import br.com.imerljak.vendor.jpa.converter.CnpjFormatConverter;
import br.com.imerljak.vendor.jpa.converter.TelefoneFormatConverter;
import lombok.*;
import org.hibernate.annotations.NaturalId;

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
@ToString(callSuper = true, exclude = {"responsaveis", "ouvidorias", "servicos"})
@EqualsAndHashCode(callSuper = true,
        exclude = {"responsaveis", "ouvidorias", "servicos"})
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cnpj"}))
public class Concessionaria extends BasicEntity {

    private static final long serialVersionUID = -210267340348887485L;

    @NonNull
    @NotEmpty
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String nome;

    @NaturalId
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
    @Column(nullable = false)
    private String email;

    @Valid
    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsavel> responsaveis = new ArrayList<>();

    @OneToMany(mappedBy = "concessionaria")
    private List<Ouvidoria> ouvidorias = new ArrayList<>();

    @ManyToMany
    private Set<TipoServico> servicos = new HashSet<>();

}
