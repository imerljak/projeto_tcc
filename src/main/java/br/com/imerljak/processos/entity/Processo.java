package br.com.imerljak.processos.entity;

import br.com.imerljak.common.entity.AuditableEntity;
import br.com.imerljak.concessionarias.entity.Concessionaria;
import br.com.imerljak.denuncias.entity.Denuncia;
import br.com.imerljak.processos.control.SituacaoProcesso;
import br.com.imerljak.usuarios.entity.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@ToString(callSuper = true,
        exclude = {"tramites", "documentos", "denuncias"})
@EqualsAndHashCode(callSuper = true,
        exclude = {"tramites", "documentos", "denuncias"})
public class Processo extends AuditableEntity {

    private static final long serialVersionUID = -7779592815770774218L;

    @NotNull
    @Column(unique = true, nullable = false, length = 80)
    private String protocolo;

    @NotNull
    @Column(nullable = false)
    private String assunto;

    @Lob
    @Column
    private String observacoes;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private SituacaoProcesso situacao; // todo: inicializar valor padrão.

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
    private Set<Denuncia> denuncias = new HashSet<>();

}