package br.com.auth.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.auth.services.CustomUserDatailService;
import br.com.auth.services.UserService;

import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDatailService customUserDatailService;

	@Autowired
	private UserService userService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and().csrf()
				.disable().authorizeRequests()

				.antMatchers("/public/**", "/app/user", "/app/user/confirm/").permitAll()
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()

				.anyRequest().authenticated().and()
				.addFilter(new JwtAuthentication(authenticationManager(), userService))
				.addFilter(new JwtAuthorization(authenticationManager(), customUserDatailService))

				// .formLogin()
				// .loginPage("/views/login")
				// .permitAll()

				// .and()
				.logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).permitAll();
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDatailService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

	}

}
