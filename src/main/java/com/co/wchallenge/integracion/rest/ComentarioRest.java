package com.co.wchallenge.integracion.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.consulta.ComentarioConsulta;
import com.co.wchallenge.dominio.modelo.Comentario;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ComentarioRest {

	private final ComentarioConsulta comentarioConsulta;
	
	@GetMapping("/ops/comentario")
	@Operation(summary = "obtenerComentarios: Obtiene los comentarios desde el servicio jsonplaceholder, puede filtrar por el correo del usuario que realizo el comentario y el nombre del comentario")
	public ResponseEntity<List<Comentario>> obtenerComentarios (
			@RequestParam(required = false) Optional<String> correo,
			@RequestParam(required = false) Optional<String> nombreComentario) {
		List<Comentario> comentarios = comentarioConsulta.obtenerComentarios(correo, nombreComentario);
		return comentarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(comentarios);
	}

}
