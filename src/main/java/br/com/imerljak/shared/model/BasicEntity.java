package br.com.imerljak.shared.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Israel Merljak <imerljak@gmail.com.br>
 */

@Data
@MappedSuperclass
@NoArgsConstructor
public class BasicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private Long versao;

    @Transient
    public boolean isNew() {
        return (getId() == null) && (getVersao() == null);
    }
}