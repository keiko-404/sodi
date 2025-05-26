package pe.edu.utp.isi.dwi.sodi.sodi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pe.edu.utp.isi.dwi.sodi.sodi.service.JwtFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean // para q las contraseñas se muestren como cifrado
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // permite acceder a la url y si es otra direccion, tiene que estar autenticado
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // login, registro libre
                .requestMatchers("/api/admin/**").hasAuthority("Admin") // admin puede crear usuarios, colaboradores
                .requestMatchers("/api/usuario/**").hasAuthority("Usuario") // usuario puede ver/registrar solicitudes
                .requestMatchers("/api/colaborador/**").hasAuthority("Colaborador") // colaborador ve solo sus solicitudes
                .requestMatchers("/solicitudes/**").hasAnyAuthority("Admin", "Colaborador")
                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
