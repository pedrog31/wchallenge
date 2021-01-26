package com.co.wchallenge.sistema.seguridad.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy;

import com.co.wchallenge.sistema.seguridad.manejador.AutenticacionDenegadaManejador;
import com.co.wchallenge.sistema.seguridad.manejador.AutenticacionInvalidaManejador;
import com.co.wchallenge.sistema.seguridad.servicio.AutenticacionTokenServicio;
import com.co.wchallenge.sistema.seguridad.servicio.FiltroTokenServicio;
import com.co.wchallenge.sistema.seguridad.servicio.TokenSeguridadServicio;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	private static final String[] URL_PERMITIDA = {
			// swagger ui
			"/swagger-ui/**",
			"/v3/api-docs/**", 
			"/swagger-ui.html", 
			"/swagger-resources", 
			"/swagger-resources/**", 
			"/configuration/ui",
			"/configuration/security", 
			"/webjars/**",
			// Servicios autenticacion
			"/au/**",
			// validacion salud
			"/health"
		};
	
	private TokenSeguridadServicio tokenSeguridadServicio;

	public ConfiguracionSeguridad(TokenSeguridadServicio tokenSeguridadServicio) {
		this.tokenSeguridadServicio = tokenSeguridadServicio;
	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AutenticacionTokenServicio(tokenSeguridadServicio));
    }

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(HttpMethod.OPTIONS);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable()//.csrfTokenRepository(this.getCsrfTokenRepository()).and()
				.headers()
				.httpStrictTransportSecurity (
						hsts -> hsts.includeSubDomains(true).preload(true).maxAgeInSeconds(31536000))
				.contentSecurityPolicy("script-src 'self' 'sha256-uGJV1INRCzRQ65HtahUNomtGV0G2E/dzVWsvQpazKHw='").and()
				.referrerPolicy(ReferrerPolicy.SAME_ORIGIN).and()
				.featurePolicy("geolocation 'self'");
		httpSecurity.authorizeRequests()
			.antMatchers(URL_PERMITIDA).permitAll()
			.antMatchers("/us/**").authenticated()
			.antMatchers("/ops/**").hasAuthority(TokenSeguridadServicio.ADMINISTRADOR_ROL)
			.anyRequest().denyAll().and() // .permitAll() // .denyAll()
			.exceptionHandling().authenticationEntryPoint(new AutenticacionInvalidaManejador()).accessDeniedHandler(new AutenticacionDenegadaManejador())
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(new FiltroTokenServicio(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
	}
	
	@SuppressWarnings("unused")
	private CsrfTokenRepository getCsrfTokenRepository() {
        CookieCsrfTokenRepository tokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        tokenRepository.setCookiePath("/");
        tokenRepository.setCookieDomain("udea.edu.co");
        return tokenRepository;
	}
	
	@Bean
	public PasswordEncoder codificadorContrasenas() {
	    return new BCryptPasswordEncoder();
	}
}
