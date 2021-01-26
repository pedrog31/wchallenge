package com.co.wchallenge.sistema.configuracion.dominio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.wchallenge.dominio.consulta.AlbumConsulta;
import com.co.wchallenge.dominio.repositorio.consulta.AlbumConsultaRepositorio;

@Configuration
public class AlbumConfiguracion {

	@Bean
	AlbumConsulta crearAlbumConsulta(AlbumConsultaRepositorio albumConsultaRepositorio) {
		return new AlbumConsulta(albumConsultaRepositorio);
	}
	
}
