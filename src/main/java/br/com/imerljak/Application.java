package br.com.imerljak;

import br.com.imerljak.utils.UploadPath;
import lombok.extern.slf4j.Slf4j;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import java.beans.PropertyEditor;
import java.io.File;

@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        for (UploadPath value : UploadPath.values()) {
            log.info("Creating path {}? {}", value.getPath(), new File(value.getPath()).mkdir());
        }

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public PropertyEditor stringTrimmedEditor() {
        return new StringTrimmerEditor(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
