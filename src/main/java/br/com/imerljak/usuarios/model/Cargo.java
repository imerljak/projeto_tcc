package br.com.imerljak.usuarios.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(of = "id")
public class Cargo implements Serializable {

    public static final String CARGO_REVISOR_RELATOR = "REVISOR_RELATOR";
    public static final String CARGO_GERENTE = "GERENTE";
    public static final String CARGO_ADMINISTRADOR = "ADMINISTRADOR";

    public static final Cargo REVISOR_RELATOR = new Cargo(CARGO_REVISOR_RELATOR);
    public static final Cargo GERENTE = new Cargo(CARGO_GERENTE);
    public static final Cargo ADMINISTRADOR = new Cargo(CARGO_ADMINISTRADOR);

    private static final long serialVersionUID = 1037038305031850351L;

    @Id
    @NonNull
    @NotEmpty
    @Column(length = 20)
    private String id;

    @NonNull
    @NotEmpty
    @Column(length = 50, nullable = false)
    private String nome;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Short nivel;

    @ManyToMany(mappedBy = "cargos")
    private Set<Usuario> usuarios = new HashSet<>();

    private Cargo(String id) {this.id = "ROLE_".concat(id);}

    @Override
    public String toString() {
        return getNome();
    }
}
