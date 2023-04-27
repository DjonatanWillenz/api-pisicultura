package br.com.api.configs;

import br.com.api.dtos.AuthDto;
import br.com.api.dtos.UserSessionDto;
import br.com.api.models.UserSystem;
import br.com.api.services.UserService;
import br.com.api.utils.UtilsJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JwtAuthentication extends UsernamePasswordAuthenticationFilter {

    private UserService userService;
    private AuthenticationManager authenticationManager;

    public JwtAuthentication(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            AuthDto user = new ObjectMapper()
                    .readValue(request.getInputStream(), AuthDto.class);
            return this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getEmial(), user.getPassword()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        UserSystem userAuth = userService.findByUsername(user.getUsername());
        String token = Jwts.builder()
                .setSubject(((User) authResult.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityTypes.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityTypes.SCRET)
                .compact();
        response.getWriter().write(UtilsJson.getInstance().toJson(
                UserSessionDto.builder()
                        .id(userAuth.getId())
                        .username(userAuth.getUsername())
                        .email(userAuth.getEmail().getEmail())
                        .name(userAuth.getName())
                        .password(userAuth.getPassword().getPassword())
                        .token(SecurityTypes.TOKEN_PREFIX + token)
                        .build()));
        response.addHeader(SecurityTypes.HEADER_STRING, SecurityTypes.TOKEN_PREFIX + token);
    }
}
