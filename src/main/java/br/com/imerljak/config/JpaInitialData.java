package br.com.imerljak.config;

import br.com.imerljak.common.boundary.TipoTramiteRepository;
import br.com.imerljak.common.entity.TipoTramite;
import br.com.imerljak.concessionarias.boundary.TipoServicoRepository;
import br.com.imerljak.concessionarias.entity.TipoServico;
import br.com.imerljak.processos.boundary.TipoDocumentoRepository;
import br.com.imerljak.processos.boundary.TipoProcessoRepository;
import br.com.imerljak.processos.entity.TipoDocumento;
import br.com.imerljak.processos.entity.TipoProcesso;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaInitialData {

    @Bean
    public CommandLineRunner loadTiposServico(TipoServicoRepository repository) {
        return (args) -> {
            repository.save(TipoServico.builder().nome("Transporte Público").build());
            repository.save(TipoServico.builder().nome("Água e Esgoto").build());
        };
    }

    @Bean
    public CommandLineRunner loadTiposDocumento(TipoDocumentoRepository repository) {
        return (args) -> {
            repository.save(TipoDocumento.builder().nome("Despacho Abertura").build());
            repository.save(TipoDocumento.builder().nome("Despacho Requerimento").build());
            repository.save(TipoDocumento.builder().nome("Despacho Decisões").build());
            repository.save(TipoDocumento.builder().nome("Notificação").build());
            repository.save(TipoDocumento.builder().nome("Oficio").build());
            repository.save(TipoDocumento.builder().nome("Auto de Infração").build());
            repository.save(TipoDocumento.builder().nome("Relatório").build());
        };
    }

    @Bean
    public CommandLineRunner loadTiposProcesso(TipoProcessoRepository repository) {
        return (args) -> {
            repository.save(TipoProcesso.builder().nome("Fiscalização").build());
            repository.save(TipoProcesso.builder().nome("Reajuste Tarifário").build());
            repository.save(TipoProcesso.builder().nome("Revisão Tarifária").build());
        };
    }

    @Bean
    public CommandLineRunner loadTiposTramite(TipoTramiteRepository repository) {
        return (args) -> {
            repository.save(TipoTramite.builder().nome("Abertura").build());
            repository.save(TipoTramite.builder().nome("Fechamento").build());
        };
    }

}
