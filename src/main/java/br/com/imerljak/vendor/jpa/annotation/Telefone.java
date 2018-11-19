package br.com.imerljak.vendor.jpa.annotation;

import br.com.imerljak.vendor.jpa.validator.TelefoneFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = TelefoneFormatValidator.class)
public @interface Telefone {

    String message() default "{br.com.imerljak.agesb.bean.validation.Telefone}";

    boolean formatted() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
