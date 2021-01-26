package com.co.wchallenge.sistema.configuracion.dominio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.wchallenge.dominio.consulta.ComentarioConsulta;
import com.co.wchallenge.dominio.repositorio.consulta.ComentarioConsultaRepositorio;

@Configuration
public class ComentarioConfiguracion {

	@Bean
	ComentarioConsulta crearComentarioConsulta(ComentarioConsultaRepositorio comentarioConsultaRepositorio) {
		return new ComentarioConsulta(comentarioConsultaRepositorio);
	}
	
}
