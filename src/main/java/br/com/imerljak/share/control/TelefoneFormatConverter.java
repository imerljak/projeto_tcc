package br.com.imerljak.share.control;

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
