package br.com.imerljak.vendor.jpa.converter;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.Validator;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DocumentoJpaConverter implements AttributeConverter<String, String> {

    private static final Formatter CNPJ_FORMATTER = new CNPJFormatter();
    private static final Validator<String> CNPJ_VALIDATOR = new CNPJValidator();

    private static final Formatter CPF_FORMATTER = new CPFFormatter();
    private static final Validator<String> CPF_VALIDATOR = new CPFValidator();

    @Override
    public String convertToDatabaseColumn(String s) {
        if (CNPJ_VALIDATOR.isEligible(s)) {
            return CNPJ_FORMATTER.unformat(s);
        }

        if (CPF_VALIDATOR.isEligible(s)) {
            return CPF_FORMATTER.unformat(s);
        }

        return s;
    }

    @Override
    public String convertToEntityAttribute(String s) {
        if (CNPJ_VALIDATOR.isEligible(s)) {
            return CNPJ_FORMATTER.format(s);
        }

        if (CPF_VALIDATOR.isEligible(s)) {
            return CPF_FORMATTER.format(s);
        }

        return s;
    }

}
