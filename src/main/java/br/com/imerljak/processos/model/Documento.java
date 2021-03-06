package br.com.imerljak.processos.model;

import br.com.imerljak.shared.model.Arquivo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true, of = {})
@EqualsAndHashCode(callSuper = true, of = {})
public class Documento extends Arquivo {

    private static final long serialVersionUID = -8398942158105186355L;

    @Basic
    private String procedencia;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Processo processo;

}