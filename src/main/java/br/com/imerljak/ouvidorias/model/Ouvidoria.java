package br.com.imerljak.ouvidorias.model;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.ouvidorias.listener.OuvidoriaEntityListener;
import br.com.imerljak.ouvidorias.value.SituacaoOuvidoria;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import br.com.imerljak.processos.model.Processo;
import br.com.imerljak.shared.model.AuditableEntity;
import br.com.imerljak.shared.model.Protocolo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
@EntityListeners(OuvidoriaEntityListener.class)
@ToString(callSuper = true, of = "protocolo")
@EqualsAndHashCode(callSuper = true, of = {})
public class Ouvidoria extends AuditableEntity {

    private static final long serialVersionUID = 8340651480291045404L;

    @NaturalId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, unique = true)
    private Protocolo protocolo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoOuvidoria tipo;

    @Valid
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(updatable = false)
    private Concessionaria concessionaria;

    @Valid
    @NotNull
    @OneToOne(cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(updatable = false)
    private Cidadao cidadao = new Cidadao();

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataOcorrencia;

    @Basic
    @NotNull
    private String manifestacao;

    @Basic
    private String localOcorrencia;

    @Basic
    private String providencia;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SituacaoOuvidoria situacao = SituacaoOuvidoria.AGUARDANDO;

    @OneToMany(mappedBy = "ouvidoria")
    private List<TramiteOuvidoria> tramites = new ArrayList<>();

    @OneToMany(mappedBy = "ouvidoria", cascade = CascadeType.ALL)
    private List<AnexoOuvidoria> anexos = new ArrayList<>();

    @ManyToMany(mappedBy = "ouvidorias")
    private Set<Processo> processos = new HashSet<>();

    public void addAnexo(AnexoOuvidoria anexo) {
        if (!this.anexos.contains(anexo)) {
            anexo.setOuvidoria(this);
            this.anexos.add(anexo);
        }
    }

    public void removeAnexo(AnexoOuvidoria anexo) {
        if (this.anexos.remove(anexo)) {
            anexo.setOuvidoria(null);
        }
    }
}