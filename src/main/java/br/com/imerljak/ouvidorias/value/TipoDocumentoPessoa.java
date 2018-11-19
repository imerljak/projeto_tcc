package br.com.imerljak.ouvidorias.value;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.Validator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoDocumentoPessoa {
    CPF(new CPFValidator(true), new CPFFormatter()),
    CNPJ(new CNPJValidator(true), new CNPJFormatter());

    private final Validator<String> validator;
    private final Formatter formatter;
}
