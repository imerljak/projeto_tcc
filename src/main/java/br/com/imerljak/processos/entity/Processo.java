
package br.com.imerljak.processos.entity;

import br.com.imerljak.common.entity.SoftDeleteEntity;
import br.com.imerljak.concessionarias.entity.Concessionaria;
import br.com.imerljak.denuncias.entity.Denuncia;
import br.com.imerljak.usuarios.entity.Usuario;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
//@SQLDelete(sql = "UPDATE processo SET removido = 1 WHERE id = ? AND version = ?")
//@SQLDeleteAll(sql = "UPDATE processo SET removido = 1")
//@Where(clause = "removido = 0")
public class Processo extends SoftDeleteEntity {

    private static final long serialVersionUID = -7779592815770774218L;

    @Column(unique = true, nullable = false)
    @Basic(optional = false)
    @NotNull
    private String protocolo;

    @Column(nullable = false)
    @Basic(optional = false)
    @NotNull
    private String nome;

    @Basic
    private String observacoes;

    @Column(nullable = false)
    @Basic
    @NotNull
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Concessionaria concessionaria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario relator;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario revisor;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario criador;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoProcesso tipoProcesso;

    @OneToMany(mappedBy = "processo")
    private List<TramiteProcesso> tramites;

    @OneToMany(mappedBy = "processo")
    private List<Documento> documentos;

    @ManyToMany
    private List<Denuncia> denuncias;

    public String getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Concessionaria getConcessionaria() {
        return this.concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

    public Optional<Usuario> getRelator() {
        return Optional.ofNullable(this.relator);
    }

    public void setRelator(Usuario relator) {
        this.relator = relator;
    }

    public Optional<Usuario> getRevisor() {
        return Optional.ofNullable(this.revisor);
    }

    public void setRevisor(Usuario revisor) {
        this.revisor = revisor;
    }

    public Usuario getCriador() {
        return this.criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public TipoProcesso getTipoProcesso() {
        return this.tipoProcesso;
    }

    public void setTipoProcesso(TipoProcesso tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public List<TramiteProcesso> getTramites() {
        if (tramites == null) {
            tramites = new ArrayList<>();
        }
        return this.tramites;
    }

    public void setTramites(List<TramiteProcesso> tramites) {
        this.tramites = tramites;
    }

    public void addTramite(TramiteProcesso tramite) {
        getTramites().add(tramite);
        tramite.setProcesso(this);
    }

    public void removeTramite(TramiteProcesso tramite) {
        getTramites().remove(tramite);
        tramite.setProcesso(null);
    }

    public List<Documento> getDocumentos() {
        if (documentos == null) {
            documentos = new ArrayList<>();
        }
        return this.documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public void addDocumento(Documento documento) {
        getDocumentos().add(documento);
        documento.setProcesso(this);
    }

    public void removeDocumento(Documento documento) {
        getDocumentos().remove(documento);
        documento.setProcesso(null);
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
        denuncia.getProcessos().add(this);
    }

    public void removeDenuncia(Denuncia denuncia) {
        getDenuncias().remove(denuncia);
        denuncia.getProcessos().remove(this);
    }

}