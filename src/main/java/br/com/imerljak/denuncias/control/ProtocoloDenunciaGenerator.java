package br.com.imerljak.denuncias.control;

import br.com.imerljak.denuncias.boundary.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service("protocoloDenuncia")
public class ProtocoloDenunciaGenerator implements StringGenerator {

    private final DenunciaRepository repository;

    @Autowired
    public ProtocoloDenunciaGenerator(DenunciaRepository repository) {this.repository = repository;}

    @Override
    public String generate() {
        LocalDateTime startOfYear = LocalDate.now().withDayOfYear(1).atStartOfDay();
        int denunciasCountFromStartOfYear = repository.countDenunciasByDataCriacaoAfter(startOfYear);
        return startOfYear.getYear() + "/" + String.format("%05d", (denunciasCountFromStartOfYear + 1));
    }
}
