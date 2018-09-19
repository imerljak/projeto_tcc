package br.com.imerljak.common.control;

import br.com.caelum.stella.format.BaseFormatter;
import br.com.caelum.stella.format.Formatter;

public class TelefoneFormatter implements Formatter {

    private final BaseFormatter base;

    public TelefoneFormatter() {
        this.base = new BaseFormatter(
                TelefoneValidator.FORMATED,
                "($1) $2-$3",
                TelefoneValidator.UNFORMATED,
                "$1$2$3"
        );
    }

    @Override
    public String format(String value) throws IllegalArgumentException {
        return base.format(value);
    }

    @Override
    public String unformat(String value) throws IllegalArgumentException {
        return base.unformat(value);
    }

    @Override
    public boolean isFormatted(String value) {
        return base.isFormatted(value);
    }

    @Override
    public boolean canBeFormatted(String value) {
        return base.canBeFormatted(value);
    }
}
