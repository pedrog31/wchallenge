package com.co.wchallenge.integracion.persistencia.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.wchallenge.dominio.modelo.Comentario;
import com.co.wchallenge.dominio.repositorio.consulta.ComentarioConsultaRepositorio;
import com.co.wchallenge.integracion.persistencia.rest.constructor.ComentarioConstructor;
import com.co.wchallenge.integracion.persistencia.rest.dto.ComentarioDTO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ComentarioConsultaRepositorioRest implements ComentarioConsultaRepositorio {

	private final RestTemplate plantillaRest;
	
	@Override
	public List<Comentario> obtenerComentarios(Optional<String> correo,	Optional<String> nombreComentario) {
		UriComponents uri = UriComponentsBuilder
				.fromPath("/comments")
				.queryParamIfPresent("email", correo)
				.queryParamIfPresent("name", nombreComentario)
				.build();
		return Arrays.asList(plantillaRest.getForObject(uri.toUriString(), ComentarioDTO[].class)).stream()
				.map(ComentarioConstructor::convertirADominio).collect(Collectors.toList());
	}

}
