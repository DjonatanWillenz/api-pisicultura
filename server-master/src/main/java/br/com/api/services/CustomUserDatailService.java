package br.com.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.api.models.UserSystem;

@Component
public class CustomUserDatailService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDatailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSystem user = Optional.ofNullable(userService.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
        if (!user.isConfirmed())
            throw new UsernameNotFoundException("Usuário não realizou a confirmação do seu cadastro!");
        if (!user.isActive())
            throw new UsernameNotFoundException("Este cadastro não esta ativo, entre em contato com o suporte!");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        String pass = new BCryptPasswordEncoder().encode(user.getPassword().getPassword());
        return new User(user.getUsername(), pass, /* user.isAdmin() ? authorityListAdmin : */ authorityListUser);
    }
}
