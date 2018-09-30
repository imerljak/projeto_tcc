package br.com.imerljak.denuncias.entity;

import br.com.imerljak.common.entity.Pessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */
@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true,
        exclude = {"denuncias"})
@EqualsAndHashCode(callSuper = true,
        exclude = {"denuncias"})
@DiscriminatorValue("DENUNCIANTE")
public class Denunciante extends Pessoa {

    private static final long serialVersionUID = 1238412128962205476L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "denunciante")
    private List<Denuncia> denuncias = new ArrayList<>();
}