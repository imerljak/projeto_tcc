package br.com.imerljak.common.control;

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
