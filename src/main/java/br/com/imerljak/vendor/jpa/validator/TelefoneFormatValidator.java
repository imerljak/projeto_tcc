package br.com.imerljak.vendor.jpa.validator;

import br.com.imerljak.vendor.jpa.annotation.Telefone;
import br.com.imerljak.vendor.stella.validator.TelefoneValidator;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneFormatValidator implements ConstraintValidator<Telefone, String> {

    private boolean isFormatted;

    public void initialize(Telefone constraint) {
        isFormatted = constraint.formatted();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {

        if (StringUtils.isEmpty(obj)) {
            return false;
        }

        return new TelefoneValidator(isFormatted).invalidMessagesFor(obj).isEmpty();
    }
}
