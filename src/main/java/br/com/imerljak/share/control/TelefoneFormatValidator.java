package br.com.imerljak.share.control;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class TelefoneFormatValidator implements ConstraintValidator<Telefone, String> {

    private boolean isFormatted;
    private boolean isOptional;

    public void initialize(Telefone constraint) {
        isFormatted = constraint.formatted();
        isOptional = constraint.optional();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {

        // Retorna false, se e somente se, o valor não for vázio e possuir um formato inválido.
        if (isOptional && StringUtils.isEmpty(obj)) {
            return true;
        }

        return new TelefoneValidator(isFormatted).invalidMessagesFor(obj).isEmpty();
    }
}
