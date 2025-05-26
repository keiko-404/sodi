package pe.edu.utp.isi.dwi.sodi.sodi.service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    // evalua con prioridad el filtro en relacion al token
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // de la peticion que yo envio, recupero la cabecera de autorizacion  
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        // dentor de la autorizacion, hay un tipo Bearer lleva consigo la identificacion del token
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // el token se recupera aqui 
        jwt = authHeader.substring(7);
        username = jwtService.extractUsername(jwt);

        // se verifica que el token es válido
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // si es válido le da las credenciales de acceso para poder consumir el servicio determinado
            if (jwtService.isTokenValid(jwt, username)) {
                // Extraemos los roles del token
                List<String> roles = jwtService.extractRoles(jwt);

                // Convertimos los roles String a objetos GrantedAuthority
                List<GrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                // Creamos el token de autenticación con roles
                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(username, null, authorities);

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
