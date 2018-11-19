package br.com.imerljak.vendor.jpa.converter;

import br.com.imerljak.vendor.stella.formatter.util.TelefoneUtil;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TelefoneFormatConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String s) {
        return TelefoneUtil.unformat(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return TelefoneUtil.format(s);
    }

}
