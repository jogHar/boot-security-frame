package com.joghar.config;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Deltafixes", "", "");
		return new ApiInfoBuilder()
				.title("Spring Security Frame")
				.contact(contact)
				.version("1.0").build();
	}
	
	@Bean
	public Docket docket(ServletContext servletContext) {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.securitySchemes(Arrays.asList(apiKey()))
				.securityContexts(Arrays.asList(securityContext())).select()
				.apis(RequestHandlerSelectors.basePackage("com.joghar.controller")).paths(PathSelectors.any())
				.build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any())
				.build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
	}
}
