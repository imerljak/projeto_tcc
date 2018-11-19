package br.com.imerljak.dashboard.service;

import br.com.imerljak.ouvidorias.service.OuvidoriaRepository;
import br.com.imerljak.ouvidorias.value.TipoOuvidoria;
import br.com.imerljak.processos.service.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Service
public class DashboardService {

    private final OuvidoriaRepository ouvidoriaRepository;
    private final ProcessoRepository processoRepository;

    @Autowired
    public DashboardService(OuvidoriaRepository ouvidoriaRepository, ProcessoRepository processoRepository) {
        this.ouvidoriaRepository = ouvidoriaRepository;
        this.processoRepository = processoRepository;
    }

    public Integer countDenunciasAt(Month month) {
        return ouvidoriaRepository
                .countByDataCriacaoBetweenAndTipo(
                        getStartOfMonth(month),
                        getEndOfMonth(month),
                        TipoOuvidoria.DENUNCIA
                );
    }

    public Integer countProcessosAt(Month month) {
        return processoRepository
                .countProcessosByDataCriacaoBetween(
                        getStartOfMonth(month),
                        getEndOfMonth(month)
                );
    }

    private LocalDateTime getEndOfMonth(Month month) {
        return LocalDate.now().withMonth(month.getValue()).withDayOfMonth(month.length(false))
                .atTime(23, 59, 59);
    }

    private LocalDateTime getStartOfMonth(Month month) {
        return LocalDate.now().atStartOfDay().withMonth(month.getValue()).withDayOfMonth(1);
    }
}
