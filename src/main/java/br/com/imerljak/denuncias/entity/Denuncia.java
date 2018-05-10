
package br.com.imerljak.denuncias.entity;

import br.com.imerljak.common.entity.BaseEntity;
import br.com.imerljak.concessionarias.entity.Concessionaria;
import br.com.imerljak.processos.entity.Processo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
public class Denuncia extends BaseEntity {

    @Basic
    private String reclamacao;

    @Basic
    private String ocorrencia;

    @Basic
    private String dataOcorrencia;

    @Basic
    private String localOcorrencia;

    @Basic
    private String sugestao;

    @Basic
    private String providencia;

    @ManyToOne(fetch = FetchType.LAZY)
    private Concessionaria concessionaria;

    @OneToMany(mappedBy = "denuncia")
    private List<TramiteDenuncia> tramites;

    @OneToMany(mappedBy = "denuncia")
    private List<AnexoDenuncia> anexos;

    @OneToMany(mappedBy = "denuncia")
    private List<Denunciante> denunciantes;

    @ManyToMany(mappedBy = "denuncias")
    private List<Processo> processos;

    @Version
    private long revisao;

    public String getReclamacao() {
        return this.reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public String getOcorrencia() {
        return this.ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getDataOcorrencia() {
        return this.dataOcorrencia;
    }

    public void setDataOcorrencia(String dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getLocalOcorrencia() {
        return this.localOcorrencia;
    }

    public void setLocalOcorrencia(String localOcorrencia) {
        this.localOcorrencia = localOcorrencia;
    }

    public String getSugestao() {
        return this.sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public String getProvidencia() {
        return this.providencia;
    }

    public void setProvidencia(String providencia) {
        this.providencia = providencia;
    }

    public Concessionaria getConcessionaria() {
        return this.concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

    public List<TramiteDenuncia> getTramites() {
        if (tramites == null) {
            tramites = new ArrayList<>();
        }
        return this.tramites;
    }

    public void setTramites(List<TramiteDenuncia> tramites) {
        this.tramites = tramites;
    }

    public void addTramite(TramiteDenuncia tramite) {
        getTramites().add(tramite);
        tramite.setDenuncia(this);
    }

    public void removeTramite(TramiteDenuncia tramite) {
        getTramites().remove(tramite);
        tramite.setDenuncia(null);
    }

    public List<AnexoDenuncia> getAnexos() {
        if (anexos == null) {
            anexos = new ArrayList<>();
        }
        return this.anexos;
    }

    public void setAnexos(List<AnexoDenuncia> anexos) {
        this.anexos = anexos;
    }

    public void addAnexo(AnexoDenuncia anexo) {
        getAnexos().add(anexo);
        anexo.setDenuncia(this);
    }

    public void removeAnexo(AnexoDenuncia anexo) {
        getAnexos().remove(anexo);
        anexo.setDenuncia(null);
    }

    public List<Denunciante> getDenunciantes() {
        if (denunciantes == null) {
            denunciantes = new ArrayList<>();
        }
        return this.denunciantes;
    }

    public void setDenunciantes(List<Denunciante> denunciantes) {
        this.denunciantes = denunciantes;
    }

    public void addDenunciante(Denunciante denunciante) {
        getDenunciantes().add(denunciante);
        denunciante.setDenuncia(this);
    }

    public void removeDenunciante(Denunciante denunciante) {
        getDenunciantes().remove(denunciante);
        denunciante.setDenuncia(null);
    }

    public List<Processo> getProcessos() {
        if (processos == null) {
            processos = new ArrayList<>();
        }
        return this.processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

    public void addProcesso(Processo processo) {
        getProcessos().add(processo);
    }

    public void removeProcesso(Processo processo) {
        getProcessos().remove(processo);
    }

    public long getRevisao() {
        return this.revisao;
    }

    public void setRevisao(long revisao) {
        this.revisao = revisao;
    }

}