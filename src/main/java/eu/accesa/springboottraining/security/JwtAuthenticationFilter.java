package eu.accesa.springboottraining.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.accesa.springboottraining.entity.Intern;
import eu.accesa.springboottraining.entity.LoginViewModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){

        // Grab credentials and map them to login viewmodel
        LoginViewModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getName(),
                credentials.getPassword(),
                new ArrayList<>());


        // Authenticate user
        try{
            Authentication auth = authenticationManager.authenticate(authenticationToken);
            return auth;
        }
        catch (Exception e){
            System.out.print(e);
        }
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Grab principal
        Intern intern = new Intern();
        intern.setName("Vlad Petrean");
        intern.setPassword("password");
        UserPrincipal principal = new UserPrincipal(intern);

        // Create JWT Token
        String token = JwtProperties.SECRET + principal.getUsername()+"-"+principal.getPassword();
        System.out.print("TOKEN: "+ token);
        // Add token in response
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX +  token);
    }
}

