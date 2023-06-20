package com.ikm.citizen.config;


import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.SpringDocConfigProperties;
import org.springdoc.core.converters.WebFluxSupportConverter;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        ModelConverters.getInstance()
                .addConverter(new WebFluxSupportConverter
                        (new ObjectMapperProvider
                                (new SpringDocConfigProperties())));

        return new OpenAPI().info(new Info().title("citizen").version("v0.0.1"));
    }
}
