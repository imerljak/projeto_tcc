package br.com.imerljak.shared.controller;

import br.com.imerljak.shared.model.Anexo;
import br.com.imerljak.shared.service.AnexoRepository;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping("/files")
@Controller
public class ArquivoController {

    private final AnexoRepository anexoRepository;

    public ArquivoController(AnexoRepository anexoRepository) {this.anexoRepository = anexoRepository;}

    @GetMapping(value = "/anexos/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] getAnexo(@PathVariable Long id) throws IOException {

        final Anexo one = anexoRepository.getOne(id);

        if (one == null) {
            return null;
        }

        InputStream in = new FileInputStream(one.asFile());

        return IOUtils.toByteArray(in);
    }

}
