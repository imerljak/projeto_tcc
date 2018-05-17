
package br.com.imerljak.concessionarias.entity;

import br.com.imerljak.common.entity.SoftDeleteEntity;
import br.com.imerljak.denuncias.entity.Denuncia;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.util.AutoPopulatingList;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
//@SQLDelete(sql = "UPDATE concessionaria SET removido=1 WHERE id=? AND version=?")
//@SQLDeleteAll(sql = "UPDATE concessionaria SET removido=1 WHERE id=? AND version=?")
//@Where(clause = "removido=0")
public class Concessionaria extends SoftDeleteEntity {

    private static final long serialVersionUID = -210267340348887485L;

    @NotEmpty
    @Basic(optional = false)
    @Column(nullable = false)
    private String nome;

    @CNPJ
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private String cnpj;

    @Basic
    private String endereco;

    @Basic
    private String telefone;

    @OneToMany
    private List<Representante> representantes = new AutoPopulatingList<>(Representante.class);

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

    public void setCnpj(String cnpj) {
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
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
