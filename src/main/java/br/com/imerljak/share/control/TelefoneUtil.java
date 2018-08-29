package br.com.imerljak.share.control;

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
