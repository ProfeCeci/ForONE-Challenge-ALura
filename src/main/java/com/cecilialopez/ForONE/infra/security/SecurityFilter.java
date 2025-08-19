package com.cecilialopez.ForONE.infra.security;

import com.cecilialopez.ForONE.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService; // Esta línea es crucial
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("1. SecurityFilter: El filtro ha sido invocado para la ruta: " + request.getRequestURI());

        if ("/login".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            System.out.println("2. SecurityFilter: Encabezado Authorization encontrado.");
            var token = authHeader.replace("Bearer ", "");
            var subject = tokenService.getSubject(token);
            if (subject != null) {
                System.out.println("3. SecurityFilter: Subject (" + subject + ") extraído del token.");
                var user = userRepository.findByLogin(subject);
                if (user != null) {
                    System.out.println("4. SecurityFilter: Usuario encontrado en la BD. Estableciendo autenticación.");
                    var authentication = new UsernamePasswordAuthenticationToken(user, null,
                            user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    System.out.println("4. SecurityFilter: ERROR - Usuario no encontrado en la BD para el subject: " + subject);
                }
            } else {
                System.out.println("3. SecurityFilter: ERROR - No se pudo obtener el subject del token.");
            }
        } else {
            System.out.println("2. SecurityFilter: No se encontró encabezado Authorization. Pasando al siguiente filtro.");
        }
        filterChain.doFilter(request, response);
    }
}
