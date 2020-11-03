package eu.accesa.springboottraining.security;

import eu.accesa.springboottraining.dao.InternRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private InternRepository internRepository;
    private JwtParser parser;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, InternRepository internRepository) {
        super(authenticationManager);
        this.internRepository = internRepository;
        this.parser = Jwts.parser()
                .setSigningKey(JwtProperties.SECRET.getBytes());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException {
        // Read the Authorization header, where the JWT token should be
        String header = request.getHeader(JwtProperties.HEADER_STRING);

        // If header does not contain BEARER or is null delegate to Spring impl and exit
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        // If header is present, try grab user principal from database and perform authorization
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continue filter execution
        chain.doFilter(request, response);
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKEN_PREFIX,"").replace(JwtProperties.SECRET, "");
        if (token != null) {
            // parse the token and validate it
            String[] credentials = token.split("-");
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(credentials[0], credentials[1]);
            return auth;

        }
        return null;

    }
}