package br.com.imerljak.denuncias.boundary;

import br.com.imerljak.denuncias.control.StringGenerator;
import br.com.imerljak.denuncias.entity.Denuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DenunciaService {

    private final StringGenerator protocoloGenerator;
    private final DenunciaRepository denunciaRepository;

    @Autowired
    public DenunciaService(@Qualifier("protocoloDenuncia") StringGenerator protocoloGenerator, DenunciaRepository denunciaRepository) {
        this.protocoloGenerator = protocoloGenerator;
        this.denunciaRepository = denunciaRepository;
    }

    public <S extends Denuncia> S save(S entity) {
        if (entity.isNew()) {
            entity.setProtocolo(protocoloGenerator.generate());
        }

        return denunciaRepository.save(entity);
    }

    public Page<Denuncia> findAll(Pageable pageable) {return denunciaRepository.findAll(pageable);}

    public void deleteById(Long aLong) {denunciaRepository.deleteById(aLong);}

    public Optional<Denuncia> findById(Long aLong) {return denunciaRepository.findById(aLong);}
}
