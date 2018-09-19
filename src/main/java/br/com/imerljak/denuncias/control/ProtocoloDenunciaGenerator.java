package br.com.imerljak.denuncias.control;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("denuncia")
public class ProtocoloDenunciaGenerator implements ProtocoloGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
