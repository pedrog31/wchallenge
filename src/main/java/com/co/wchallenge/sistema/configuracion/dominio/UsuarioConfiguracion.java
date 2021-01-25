package com.co.wchallenge.sistema.configuracion.dominio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.wchallenge.dominio.consulta.UsuarioConsulta;
import com.co.wchallenge.dominio.repositorio.consulta.UsuarioConsultaRepositorio;

@Configuration
public class UsuarioConfiguracion {

	@Bean
	UsuarioConsulta crearUsuarioConsulta(UsuarioConsultaRepositorio usuarioConsultaRepositorio) {
		return new UsuarioConsulta(usuarioConsultaRepositorio);
	}
	
}
