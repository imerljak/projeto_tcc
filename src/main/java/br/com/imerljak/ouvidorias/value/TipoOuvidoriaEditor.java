package br.com.imerljak.ouvidorias.value;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class TipoOuvidoriaEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
            setValue(TipoOuvidoria.valueOf(text.trim().toUpperCase()));
        }
    }

    @Override
    public String getAsText() {
        return getValue() == null ? null : getValue().toString();
    }
}
