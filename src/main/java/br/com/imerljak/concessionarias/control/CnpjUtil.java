package br.com.imerljak.concessionarias.control;

import br.com.caelum.stella.format.CNPJFormatter;

public class CnpjUtil {

    private static CNPJFormatter cnpjFormatter = new CNPJFormatter();

    public static String format(String value) {
        if (value != null && cnpjFormatter.canBeFormatted(value)) {
            return cnpjFormatter.format(value);
        }

        return value;
    }

    public static String unformat(String value) {
        if (value != null && cnpjFormatter.isFormatted(value)) {
            return cnpjFormatter.unformat(value);
        }

        return value;
    }
}
