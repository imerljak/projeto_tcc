package br.com.imerljak.vendor.jpa.converter;

import br.com.imerljak.concessionarias.util.CnpjUtil;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CnpjFormatConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String s) {
        return CnpjUtil.unformat(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return CnpjUtil.format(s);
    }
}
