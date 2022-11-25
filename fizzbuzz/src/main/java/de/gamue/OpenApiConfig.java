package de.gamue;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI publicApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Playground APIs")
                        .description("Documentation of the REST APIs")
                        .version("1.0"));
    }

}
