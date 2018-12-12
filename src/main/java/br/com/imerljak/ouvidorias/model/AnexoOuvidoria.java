package br.com.imerljak.ouvidorias.model;

import br.com.imerljak.shared.model.Anexo;
import br.com.imerljak.shared.values.DTypes;
import br.com.imerljak.utils.UploadPath;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue(DTypes.Anexo.OUVIDORIA)
public class AnexoOuvidoria extends Anexo {

    private static final long serialVersionUID = 6356713240105726798L;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Ouvidoria ouvidoria;

    public static AnexoOuvidoria from(MultipartFile file, UploadPath uploadPath) {

        final AnexoOuvidoria anexoOuvidoria = new AnexoOuvidoria();
        anexoOuvidoria.setNome(file.getOriginalFilename());
        anexoOuvidoria.setCaminho(uploadPath.getPath());

        return anexoOuvidoria;
    }
}