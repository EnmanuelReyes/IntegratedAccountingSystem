package me.enmanuel.accounting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 6/29/17
 * Time: 7:12 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(path -> path.startsWith("/api/"))
                .build()
                        .apiInfo(metaData());

    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Sistema Contabilidad",
                "Sistema Contabilidad UNAPEC",
                "1.0",
                "Terms of service",
                new Contact("Enmanuel Reyes", "https://github.com/EnmanuelReyes/", "enmanuelreyes@live.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
