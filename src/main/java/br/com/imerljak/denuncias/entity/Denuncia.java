package br.com.imerljak.denuncias.entity;

import br.com.imerljak.common.entity.BaseEntity;
import br.com.imerljak.concessionarias.entity.Concessionaria;
import br.com.imerljak.processos.entity.Processo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@ToString(callSuper = true, exclude = {"tramites", "anexos", "processos"})
@EqualsAndHashCode(callSuper = true, exclude = {"tramites", "anexos", "processos"})
public class Denuncia extends BaseEntity {

    private static final long serialVersionUID = 8340651480291045404L;

    @Basic
    private String protocolo;

    @Basic
    @NotNull
    private String reclamacao;

    @Basic
    private String ocorrencia;

    @Basic
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataOcorrencia;

    @Basic
    private String localOcorrencia;

    @Basic
    private String sugestao;

    @Basic
    private String providencia;

    @Valid
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Concessionaria concessionaria;

    @Valid
    @NotNull
    @ManyToOne(cascade = {CascadeType.ALL})
    private Denunciante denunciante;

    @OneToMany(mappedBy = "denuncia")
    private List<TramiteDenuncia> tramites = new ArrayList<>();

    @OneToMany(mappedBy = "denuncia")
    private List<AnexoDenuncia> anexos = new ArrayList<>();

    @ManyToMany(mappedBy = "denuncias")
    private Set<Processo> processos = new HashSet<>();
}