package dev.lucas.apinaruto.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI narutoAPI(){
        return new OpenAPI().
                info(new Info()
                        .title("Naruto API").version("1.0").description("Api de treinamento Acadêmico")
                        .license(new License().name("Lucas.Dev").url("https://github.com/LucasAdao")));
    }
}
