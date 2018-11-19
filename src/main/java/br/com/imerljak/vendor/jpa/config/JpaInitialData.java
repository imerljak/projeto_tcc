package br.com.imerljak.vendor.jpa.config;

import br.com.imerljak.shared.TipoTramiteRepository;
import br.com.imerljak.shared.TipoTramite;
import br.com.imerljak.concessionarias.service.TipoServicoRepository;
import br.com.imerljak.concessionarias.model.TipoServico;
import br.com.imerljak.processos.service.TipoDocumentoRepository;
import br.com.imerljak.processos.service.TipoProcessoRepository;
import br.com.imerljak.processos.model.TipoDocumento;
import br.com.imerljak.processos.model.TipoProcesso;
import br.com.imerljak.usuarios.service.UsuarioService;
import br.com.imerljak.usuarios.model.Cargo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class JpaInitialData {

//    @Bean
    public CommandLineRunner loadUsuarioAdmin(UsuarioService service) {
        return args -> {
            service.createWith(
                    "Israel Merljak",
                    "imerljak@gmail.com",
                    "123456",
                    Arrays.asList(Cargo.ADMINISTRADOR,
                                  Cargo.GERENTE,
                                  Cargo.REVISOR_RELATOR));
        };
    }

//    @Bean
    public CommandLineRunner loadTiposServico(TipoServicoRepository repository) {
        return (args) -> {
            repository.saveIfNotExistsByNome(TipoServico.builder().nome("Transporte Público").build());
            repository.saveIfNotExistsByNome(TipoServico.builder().nome("Água e Esgoto").build());
        };
    }

//    @Bean
    public CommandLineRunner loadTiposDocumento(TipoDocumentoRepository repository) {
        return (args) -> {
            repository.saveIfNotExistsByNome(TipoDocumento.builder().nome("Despacho Abertura").build());
            repository.saveIfNotExistsByNome(TipoDocumento.builder().nome("Despacho Requerimento").build());
            repository.saveIfNotExistsByNome(TipoDocumento.builder().nome("Despacho Decisões").build());
            repository.saveIfNotExistsByNome(TipoDocumento.builder().nome("Notificação").build());
            repository.saveIfNotExistsByNome(TipoDocumento.builder().nome("Oficio").build());
            repository.saveIfNotExistsByNome(TipoDocumento.builder().nome("Auto de Infração").build());
            repository.saveIfNotExistsByNome(TipoDocumento.builder().nome("Relatório").build());
        };
    }

//    @Bean
    public CommandLineRunner loadTiposProcesso(TipoProcessoRepository repository) {
        return (args) -> {
            repository.saveIfNotExistsByNome(TipoProcesso.builder().nome("Fiscalização").build());
            repository.saveIfNotExistsByNome(TipoProcesso.builder().nome("Reajuste Tarifário").build());
            repository.saveIfNotExistsByNome(TipoProcesso.builder().nome("Revisão Tarifária").build());
        };
    }

//    @Bean
    public CommandLineRunner loadTiposTramite(TipoTramiteRepository repository) {
        return (args) -> {
            repository.saveIfNotExistsByNome(TipoTramite.builder().nome("Abertura").build());
            repository.saveIfNotExistsByNome(TipoTramite.builder().nome("Fechamento").build());
        };
    }
}
