package com.co.wchallenge.sistema.configuracion.dominio;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.wchallenge.dominio.consulta.AlbumConsulta;
import com.co.wchallenge.dominio.consulta.PermisoConsulta;
import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.modelo.PermisoGestor;
import com.co.wchallenge.dominio.modelo.PermisoLector;
import com.co.wchallenge.dominio.modelo.PermisoSeguidor;
import com.co.wchallenge.dominio.repositorio.consulta.PermisoConsultaRepositorio;
import com.co.wchallenge.dominio.repositorio.servicio.PermisoServicioRepositorio;
import com.co.wchallenge.dominio.servicio.PermisoServicio;

@Configuration
public class PermisoConfiguracion {

	@Bean
	List<Permiso> crearPermisos() {
		return Arrays.asList(
				new PermisoGestor(),
				new PermisoSeguidor(),
				new PermisoLector());
	}

	@Bean
	PermisoServicio crearPermisoServicio(PermisoServicioRepositorio permisoServicioRepositorio, PermisoConsulta permisoConsulta, AlbumConsulta albumConsulta, List<Permiso> permisos) {
		return new PermisoServicio(permisoServicioRepositorio, permisoConsulta, albumConsulta, permisos);
	}

	@Bean
	PermisoConsulta crearPermisoConsulta(PermisoConsultaRepositorio permisoConsultaRepositorio) {
		return new PermisoConsulta(permisoConsultaRepositorio);
	}
	
}
