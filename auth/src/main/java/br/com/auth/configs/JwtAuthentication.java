package br.com.auth.configs;

import br.com.auth.dtos.AuthDTO;
import br.com.auth.dtos.UserSessionDTO;
import br.com.auth.models.User;
import br.com.auth.services.UserService;
import br.com.auth.utils.JsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            AuthDTO user = new ObjectMapper()
                    .readValue(request.getInputStream(), AuthDTO.class);
            return this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
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
        User userAuth = userService.findByEmail(user.getEmail());
        String token = Jwts.builder()
                .setSubject(((User) authResult.getPrincipal()).getEmail())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityTypes.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityTypes.SCRET)
                .compact();
        response.getWriter().write(JsonUtils.getInstance().toJson(
                UserSessionDTO.builder()
                        .id(userAuth.getId())
                        .email(userAuth.getEmail())
                        .name(userAuth.getName())
                        .password(userAuth.getPassword().getPassword())
                        .token(SecurityTypes.TOKEN_PREFIX + token)
                        .build()));
        response.addHeader(SecurityTypes.HEADER_STRING, SecurityTypes.TOKEN_PREFIX + token);
    }
}
