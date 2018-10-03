package br.com.imerljak.dashboard;

import br.com.imerljak.denuncias.boundary.DenunciaRepository;
import br.com.imerljak.processos.boundary.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Service
public class DashboardService {

    private final DenunciaRepository denunciaRepository;
    private final ProcessoRepository processoRepository;

    @Autowired
    public DashboardService(DenunciaRepository denunciaRepository, ProcessoRepository processoRepository) {
        this.denunciaRepository = denunciaRepository;
        this.processoRepository = processoRepository;
    }

    public Integer countDenunciasAt(Month month) {
        return denunciaRepository
                .countDenunciasByDataCriacaoBetween(
                        getStartOfMonth(month),
                        getEndOfMonth(month)
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
