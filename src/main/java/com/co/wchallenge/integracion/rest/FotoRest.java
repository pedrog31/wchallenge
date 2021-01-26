package com.co.wchallenge.integracion.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.consulta.FotoConsulta;
import com.co.wchallenge.dominio.modelo.Foto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FotoRest {

	private final FotoConsulta fotoConsulta;
	
	@GetMapping("/ops/foto")
	private ResponseEntity<List<Foto>> obtenerFotos (@RequestParam(required = false) Optional<Integer> idUsuario) {
		List<Foto> fotos = fotoConsulta.obtenerFotos(idUsuario);
		return fotos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(fotos);
	}

}
