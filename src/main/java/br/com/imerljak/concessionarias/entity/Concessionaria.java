
package br.com.imerljak.concessionarias.entity;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.imerljak.concessionarias.control.CnpjFormatConverter;
import br.com.imerljak.denuncias.entity.Denuncia;
import br.com.imerljak.share.control.Telefone;
import br.com.imerljak.share.control.TelefoneFormatConverter;
import br.com.imerljak.share.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cnpj"}))
public class Concessionaria extends BaseEntity {

    private static final long serialVersionUID = -210267340348887485L;

    @NotEmpty
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String nome;

    @NotEmpty
    @CNPJ(formatted = true)
    @Convert(converter = CnpjFormatConverter.class)
    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Basic
    private String endereco;

    @Telefone
    @Convert(converter = TelefoneFormatConverter.class)
    @Column(length = 12)
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
    private List<TipoServico> servicos = new ArrayList<>();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(@NotNull String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Representante> getRepresentantes() {
        if (representantes == null) {
            representantes = new ArrayList<>();
        }
        return this.representantes;
    }

    public void setRepresentantes(List<Representante> representantes) {
        this.representantes = representantes;
    }

    public void addRepresentante(Representante representante) {
        getRepresentantes().add(representante);
    }

    public void removeRepresentante(Representante representante) {
        getRepresentantes().remove(representante);
    }

    public List<Denuncia> getDenuncias() {
        if (denuncias == null) {
            denuncias = new ArrayList<>();
        }
        return this.denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public void addDenuncia(Denuncia denuncia) {
        getDenuncias().add(denuncia);
        denuncia.setConcessionaria(this);
    }

    public void removeDenuncia(Denuncia denuncia) {
        getDenuncias().remove(denuncia);
        denuncia.setConcessionaria(null);
    }

    public List<TipoServico> getServicos() {
        if (servicos == null) {
            servicos = new ArrayList<>();
        }
        return this.servicos;
    }

    public void setServicos(List<TipoServico> servicos) {
        this.servicos = servicos;
    }

    public void addServico(TipoServico servico) {
        getServicos().add(servico);
    }

    public void removeServico(TipoServico servico) {
        getServicos().remove(servico);
    }

    @Override
    public String toString() {
        return "Concessionaria{" +
                "id=" + getId() +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
