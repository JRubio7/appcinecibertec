package pe.edu.cibertec.appcinecibertec.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import pe.edu.cibertec.appcinecibertec.service.DetalleUsuarioService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private final DetalleUsuarioService detalleUsuarioService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.getDefaultUserDetailsService(detalleUsuarioService)
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests()
		.requestMatchers(
				"/auth/login", 
				"/auth/registro", 
				"/auth/guardarUsuario",
				"/resources/**",
				"/static/**",
				"/css/**",
				"/js/**")
		.antMatchers("/auth/login").permitAll()
		.antMatchers("/auth/registro").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin().loginPage("/auth/login")
		.defaultSuccessUrl("/home")
		.usernameParameter("nomusuario")
		.passwordParameter("password")
		.and()
		.authenticationProvider(authenticationProvider());
		
		return http.build();
	}


	@Bean
	private Object authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(detalleUsuarioService);
		authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authenticationProvider;
	}*/
	
	
}
