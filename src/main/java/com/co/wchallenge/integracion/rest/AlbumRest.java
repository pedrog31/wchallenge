package com.co.wchallenge.integracion.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.consulta.AlbumConsulta;
import com.co.wchallenge.dominio.modelo.Album;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AlbumRest {

	private final AlbumConsulta albumConsulta;
	
	@GetMapping("/ops/album")
	@Operation(summary = "obtenerAlbumes: Obtiene los albumes desde el servicio jsonplaceholder y de cada usuario si se envia el parametro idUsuario")
	public ResponseEntity<List<Album>> obtenerAlbumes (@RequestParam(required = false) Optional<Integer> idUsuario) {
		List<Album> albumes = albumConsulta.obtenerAlbumes(idUsuario);
		return albumes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(albumes);
	}
}
