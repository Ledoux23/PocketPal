package org.mtt.pocketpal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/expenses/**") // L'URL ou le chemin que l'on souhaite autoriser
                .allowedOrigins("http://localhost:4200") // L'origine (domaine) de l'application Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Les méthodes HTTP autorisées
                .allowCredentials(true); // Autorisez les cookies et les en-têtes d'authentification si nécessaire
    }
}
