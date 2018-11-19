package br.com.imerljak.vendor.jpa.validator;

import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.Validator;
import br.com.imerljak.ouvidorias.model.Cidadao;
import br.com.imerljak.vendor.jpa.annotation.DocumentoValido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Slf4j
public class DocumentoValidoValidator implements ConstraintValidator<DocumentoValido, Cidadao> {
    public void initialize(DocumentoValido constraint) {
    }

    @Override
    public boolean isValid(Cidadao cidadao, ConstraintValidatorContext context) {

        log.info("cidadao = {}", cidadao);

        if (Objects.isNull(cidadao.getTipoDocumento()) || StringUtils.isEmpty(cidadao.getDocumento())) {
            return false;
        }

        Validator<String> validator = cidadao.getTipoDocumento().getValidator();
        Formatter formatter = cidadao.getTipoDocumento().getFormatter();

        if (validator.isEligible(cidadao.getDocumento())) {

            log.info("{} é um possível {}", cidadao.getDocumento(), cidadao.getTipoDocumento());

            if (formatter.canBeFormatted(cidadao.getDocumento())) {
                log.info("valor pode ser formatado.");

                cidadao.setDocumento(formatter.format(cidadao.getDocumento()));
            }

            boolean empty = validator.invalidMessagesFor(cidadao.getDocumento()).isEmpty();
            log.info("valido? {}", empty);

            return empty;
        }

        log.info("Inválido.");
        return false;
    }
}
