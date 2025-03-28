package br.com.ninodev.cortecerto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configura a URL que pode acessar sua API (ajuste conforme sua necessidade)
        registry.addMapping("/**")  // Aplica a todos os endpoints da API
                .allowedOrigins("http://localhost:4200") // URL do frontend (Angular)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite enviar cookies e credenciais
    }
}