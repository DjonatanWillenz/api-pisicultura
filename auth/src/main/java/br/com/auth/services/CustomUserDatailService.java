package br.com.auth.services;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDatailService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDatailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        br.com.auth.models.User user = userService.findByEmail(email);
        if (!user.isConfirmed())
            throw new UsernameNotFoundException("Usuário não realizou a confirmação do seu cadastro!");
        if (!user.isActive())
            throw new UsernameNotFoundException("Este cadastro não esta ativo, entre em contato com o suporte!");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        String pass = new BCryptPasswordEncoder().encode(user.getPassword().getPassword());
        return new User(user.getEmail(), pass, /* user.isAdmin() ? authorityListAdmin : */ authorityListUser);
    }
}
