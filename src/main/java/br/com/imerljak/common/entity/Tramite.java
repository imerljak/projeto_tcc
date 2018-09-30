package br.com.imerljak.common.entity;

import br.com.imerljak.usuarios.entity.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@DiscriminatorColumn
@ToString(callSuper = true, exclude = {"anexos"})
@EqualsAndHashCode(callSuper = true, exclude = {"anexos"})
public abstract class Tramite extends BaseEntity {

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
    private List<AnexoTramite> anexos = new ArrayList<>();
}