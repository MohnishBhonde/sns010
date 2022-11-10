package com.snsimplem.sns.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@RestController
@EnableSwagger2
public class SnsApplication {
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.snsimplem"))
				.build()
				.apiInfo(ApiDetails());
	}
	private ApiInfo ApiDetails() {
		return new ApiInfo(
				"SNS Implementation",
				"SNS Implementation",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Mohnish Bhonde","","mohnish2351999@gmail.com"),
				"Api License",
				"http://localhost:3000",
				Collections.emptyList());



}




	public static void main(String[] args) {
		SpringApplication.run(SnsApplication.class, args);
	}

}
