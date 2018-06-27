package br.com.imerljak.share.control;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = TelefoneFormatValidator.class)
public @interface Telefone {
    String message() default "{br.com.imerljak.agesb.bean.validation.Telefone}";

    boolean formatted() default false;

    boolean optional() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
