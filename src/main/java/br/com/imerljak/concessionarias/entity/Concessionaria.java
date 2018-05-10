
package br.com.imerljak.concessionarias.entity;

import br.com.imerljak.common.entity.BaseEntity;
import br.com.imerljak.denuncias.entity.Denuncia;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
public class Concessionaria extends BaseEntity {

    @Column(nullable = false)
    @Basic(optional = false)
    @NotNull
    private String nome;

    @Column(unique = true, nullable = false)
    @Basic(optional = false)
    @NotNull
    @Pattern(regexp = "\\d{14}")
    private String cnpj;

    @Basic
    private String endereco;

    @Basic
    private String telefone;

    @OneToMany
    private List<Representante> representantes;

    @OneToMany(mappedBy = "concessionaria")
    private List<Denuncia> denuncias;

    @ManyToMany
    private List<TipoServico> servicos;

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

    public Optional<String> getEndereco() {
        return Optional.ofNullable(this.endereco);
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

}
