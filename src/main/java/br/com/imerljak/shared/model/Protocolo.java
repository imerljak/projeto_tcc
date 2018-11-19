package br.com.imerljak.shared.model;

import br.com.imerljak.shared.TipoProtocolo;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;

@Getter
@Setter(AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(indexes = @Index(columnList = "tipo"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"ano", "sequencia"}))
public class Protocolo extends BasicEntity {
    private static final long serialVersionUID = 5415538090003743772L;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TipoProtocolo tipo;

    @NonNull
    @NotNull
    @Column(columnDefinition = "int")
    private Year ano = Year.now();

    @NotNull
    private Long sequencia = 0L;

    public Protocolo next() {
        Protocolo protocolo = new Protocolo(tipo);
        protocolo.setAno(this.ano);
        protocolo.setSequencia(this.sequencia + 1);

        return protocolo;
    }

    public String asString() {
        return ano + "/" + String.format("%04d", sequencia);
    }
}
