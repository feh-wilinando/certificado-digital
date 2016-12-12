package br.com.fws.prac.certificado_digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public EmbeddedServletContainerCustomizer serverConf() {
		return container -> {
			ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/WEB-INF/views/errors/404.jsp");
			ErrorPage error403 = new ErrorPage(HttpStatus.FORBIDDEN, "/WEB-INF/views/errors/403.jsp");
			container.addErrorPages(error403, error404);
		};
	}

}
