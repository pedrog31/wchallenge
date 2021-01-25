package com.co.wchallenge.integracion.persistencia.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.wchallenge.dominio.modelo.Foto;
import com.co.wchallenge.dominio.repositorio.consulta.FotoConsultaRepositorio;
import com.co.wchallenge.integracion.persistencia.rest.constructor.FotoConstructor;
import com.co.wchallenge.integracion.persistencia.rest.modelo.FotoDTO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class FotoConsultaRepositorioRest implements FotoConsultaRepositorio {

	private final RestTemplate plantillaRest;

	@Override
	public List<Foto> obtenerFotos(Optional<Integer> idUsuario) {
		UriComponents builder = UriComponentsBuilder.fromPath("/photos").queryParamIfPresent("userId", idUsuario)
				.build();
		return Arrays.asList(plantillaRest.getForObject(builder.toUriString(), FotoDTO[].class)).stream()
				.map(FotoConstructor::convertirADominio).collect(Collectors.toList());
	}

}
