package cecy.cecy_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {
                private final JWTAuthenticationFilter jwtAuthfilter;
                private final AuthenticationProvider authenticationProvider;

                @Bean
                public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                                http.csrf()
                                                                .disable()
                                                                .authorizeHttpRequests()
                                                                .requestMatchers("/api/**", "/api/auth/**"
                                                                // "/api/catalogos/**", "/api/estudiantes/**"
                                                                )
                                                                .permitAll()
                                                                .anyRequest()
                                                                .authenticated()
                                                                .and()
                                                                .sessionManagement()
                                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                                                .and()
                                                                .authenticationProvider(authenticationProvider)
                                                                .addFilterBefore(jwtAuthfilter, UsernamePasswordAuthenticationFilter.class);
                                return http.build();
                }
}