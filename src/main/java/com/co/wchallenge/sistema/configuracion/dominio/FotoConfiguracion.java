package com.co.wchallenge.sistema.configuracion.dominio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.wchallenge.dominio.consulta.FotoConsulta;
import com.co.wchallenge.dominio.repositorio.consulta.FotoConsultaRepositorio;

@Configuration
public class FotoConfiguracion {

	@Bean
	FotoConsulta crearFotoConsulta(FotoConsultaRepositorio fotoConsultaRepositorio) {
		return new FotoConsulta(fotoConsultaRepositorio);
	}
	
}
