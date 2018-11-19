package br.com.imerljak.vendor.jpa.annotation;

import br.com.imerljak.vendor.jpa.validator.DocumentoValidoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DocumentoValidoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentoValido {

    String message() default "Documento Inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
