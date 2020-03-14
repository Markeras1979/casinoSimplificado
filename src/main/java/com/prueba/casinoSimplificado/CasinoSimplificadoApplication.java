package com.prueba.casinoSimplificado;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prueba.casinoSimplificado")
@EnableAutoConfiguration
public class CasinoSimplificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasinoSimplificadoApplication.class, args);
	}
	
	
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
           .setType(EmbeddedDatabaseType.HSQL)
           .build();
    }
	
	/**
	 * defaultViewResolver.
	 * 
	 * @param prefix
	 * @param sufix
	 * @param exposeContextBeansAsAttributes
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver defaultViewResolver(@Value("${spring.mvc.view.prefix}") String prefix,
			@Value("${spring.mvc.view.suffix}") String sufix,
			@Value("${spring.mvc.view.exposeContextBeansAsAttributes}") Boolean exposeContextBeansAsAttributes) {
		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(sufix);
		resolver.setViewClass(JstlView.class);
		resolver.setExposeContextBeansAsAttributes(exposeContextBeansAsAttributes);
		return resolver;
	}

}
