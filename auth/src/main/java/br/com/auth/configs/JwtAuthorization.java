package br.com.auth.configs;

import br.com.auth.services.CustomUserDatailService;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtAuthorization extends BasicAuthenticationFilter {

    private final CustomUserDatailService customUserDatailService;


    public JwtAuthorization(AuthenticationManager authenticationManager, CustomUserDatailService customUserDatailService) {
        super(authenticationManager);
        this.customUserDatailService = customUserDatailService;
    }

    public JwtAuthorization(AuthenticationManager authenticationManager, 
                            AuthenticationEntryPoint authenticationEntryPoint, 
                            CustomUserDatailService customUserDatailService) {
        super(authenticationManager, authenticationEntryPoint);
        this.customUserDatailService = customUserDatailService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityTypes.HEADER_STRING);
        if (header == null || !header.startsWith(SecurityTypes.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(SecurityTypes.HEADER_STRING);
        if (token == null) return null;
        String username = Jwts.parser()
                .setSigningKey(SecurityTypes.SCRET)
                .parseClaimsJws(token.replace(SecurityTypes.TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
        UserDetails userDetails = customUserDatailService.loadUserByUsername(username);
        return username != null
                ? new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities())
                : null;
    }    
}
