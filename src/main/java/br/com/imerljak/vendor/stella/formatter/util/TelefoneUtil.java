package br.com.imerljak.vendor.stella.formatter.util;

import br.com.imerljak.vendor.stella.formatter.TelefoneFormatter;

public class TelefoneUtil {

    public static TelefoneFormatter formatter = new TelefoneFormatter();


    public static String unformat(String s) {
        if (formatter.isFormatted(s)) {
            return formatter.unformat(s);
        }

        return s;
    }

    public static String format(String s) {
        if (formatter.canBeFormatted(s)) {
            return formatter.format(s);
        }

        return s;
    }
}
