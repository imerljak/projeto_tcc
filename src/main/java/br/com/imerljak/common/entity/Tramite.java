
package br.com.imerljak.common.entity;

import br.com.imerljak.usuarios.entity.Usuario;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
@DiscriminatorColumn
//@SQLDelete(sql = "UPDATE tramite SET removido = 1 WHERE id = ? AND version = ?")
//@SQLDeleteAll(sql = "UPDATE tramite SET removido = 1")
//@Where(clause = "removido = 0")
public abstract class Tramite extends SoftDeleteEntity {

    private static final long serialVersionUID = 8695715051300957310L;

    @Basic
    @FutureOrPresent
    private LocalDateTime dataVigencia;

    @Basic
    @FutureOrPresent
    private LocalDateTime dataLimite;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoTramite tipoTramite;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(mappedBy = "tramite")
    private List<AnexoTramite> anexos;

    public LocalDateTime getDataVigencia() {
        return this.dataVigencia;
    }

    public void setDataVigencia(LocalDateTime dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public LocalDateTime getDataLimite() {
        return this.dataLimite;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public TipoTramite getTipoTramite() {
        return this.tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<AnexoTramite> getAnexos() {
        if (anexos == null) {
            anexos = new ArrayList<>();
        }
        return this.anexos;
    }

    public void setAnexos(List<AnexoTramite> anexos) {
        this.anexos = anexos;
    }

    public void addAnexo(AnexoTramite anexo) {
        getAnexos().add(anexo);
        anexo.setTramite(this);
    }

    public void removeAnexo(AnexoTramite anexo) {
        getAnexos().remove(anexo);
        anexo.setTramite(null);
    }

}