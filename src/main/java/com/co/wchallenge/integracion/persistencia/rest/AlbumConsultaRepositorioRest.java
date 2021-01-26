package com.co.wchallenge.integracion.persistencia.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.co.wchallenge.dominio.modelo.Album;
import com.co.wchallenge.dominio.repositorio.consulta.AlbumConsultaRepositorio;
import com.co.wchallenge.integracion.persistencia.rest.constructor.AlbumConstructor;
import com.co.wchallenge.integracion.persistencia.rest.modelo.AlbumDTO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AlbumConsultaRepositorioRest implements AlbumConsultaRepositorio {

	private final RestTemplate plantillaRest;

	@Override
	public List<Album> obtenerAlbumes(Optional<Integer> idUsuario) {
		UriComponents uri = UriComponentsBuilder.fromPath("/albums").queryParamIfPresent("userId", idUsuario)
				.build();
		return Arrays.asList(plantillaRest.getForObject(uri.toUriString(), AlbumDTO[].class)).stream()
				.map(AlbumConstructor::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public List<Integer> obtenerAlbumesIdsPorUsuario(Integer idUsuario) {
		UriComponents uri = UriComponentsBuilder.fromPath("/albums").queryParam("userId", idUsuario)
				.build();
		return Arrays.asList(plantillaRest.getForObject(uri.toUriString(), AlbumDTO[].class)).stream()
				.map(AlbumDTO::getId).collect(Collectors.toList());
	}

}
