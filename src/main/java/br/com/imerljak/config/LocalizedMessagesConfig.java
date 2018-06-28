package br.com.imerljak.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocalizedMessagesConfig implements WebMvcConfigurer {

    private static final Locale DEFAULT_LOCALE = Locale.forLanguageTag("pt-BR");

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(DEFAULT_LOCALE);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setBasename("classpath:messages");
//        messageSource.setCacheSeconds(3600);
//
//        return messageSource;
//    }

//    @Bean
//    public Validator validator(MessageSource messageSource) {
//        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource);
//        return bean;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
