package br.com.alura.Forum_hub.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,"/topicos/**").permitAll() // libera apenas /topicos
                        //.requestMatchers("/**").permitAll()    // se quiser liberar tudo
                        .requestMatchers(HttpMethod.PUT,"/topicos/**").permitAll()
                        //Libera PUT em /topicos/{id} (atualizar)
                        .requestMatchers(POST,"/topicos").permitAll()
                        // Libera POST em /topicos (registrar)
                        .requestMatchers(HttpMethod.DELETE,"/topicos/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()); // necessário para POST sem token CSRF

        return http.build();
    }
}


