
package br.com.imerljak.processos.entity;

import br.com.imerljak.common.entity.Arquivo;
import br.com.imerljak.usuarios.entity.Usuario;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Entity
//@SQLDelete(sql = "UPDATE documento SET removido = 1 WHERE id = ? AND version = ?")
//@SQLDeleteAll(sql = "UPDATE documento SET removido = 1")
//@Where(clause = "removido = 0")
public class Documento extends Arquivo {

    private static final long serialVersionUID = -8398942158105186355L;

    @Basic
    private String procedencia;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Processo processo;

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario criador;

    public String getProcedencia() {
        return this.procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Processo getProcesso() {
        return this.processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Usuario getCriador() {
        return this.criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

}