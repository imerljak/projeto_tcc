package br.com.imerljak.processos.model;

import br.com.imerljak.concessionarias.model.Concessionaria;
import br.com.imerljak.ouvidorias.model.Ouvidoria;
import br.com.imerljak.processos.listener.ProcessoEntityListener;
import br.com.imerljak.processos.value.SituacaoProcesso;
import br.com.imerljak.shared.model.AuditableEntity;
import br.com.imerljak.shared.model.Protocolo;
import br.com.imerljak.usuarios.model.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
@ToString(callSuper = true, of = "protocolo")
@EqualsAndHashCode(callSuper = true, of = {})
@EntityListeners(ProcessoEntityListener.class)
public class Processo extends AuditableEntity {

    private static final long serialVersionUID = -7779592815770774218L;

    @NaturalId
    @OneToOne
    @JoinColumn(unique = true, nullable = false)
    private Protocolo protocolo;

    @NotNull
    @Column(nullable = false)
    private String assunto;

    @Lob
    @Column
    private String observacoes;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private SituacaoProcesso situacao = SituacaoProcesso.EM_ANDAMENTO; // todo: inicializar valor padrão.

    @ManyToOne(fetch = FetchType.LAZY)
    private Concessionaria concessionaria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario relator;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario revisor;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoProcesso tipoProcesso;

    @OneToMany(mappedBy = "processo")
    private List<TramiteProcesso> tramites = new ArrayList<>();

    @OneToMany(mappedBy = "processo")
    private List<Documento> documentos = new ArrayList<>();

    @ManyToMany
    private Set<Ouvidoria> ouvidorias = new HashSet<>();

}