package com.co.wchallenge.integracion.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.consulta.UsuarioConsulta;
import com.co.wchallenge.dominio.modelo.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UsuarioRest {

	private final UsuarioConsulta usuarioConsulta;
	
	@GetMapping("/ops/usuario")
	@Operation(summary = "obtenerUsuarios: Obtiene todos los usuarios disponibles desde el servicio jsonplaceholder")
	public ResponseEntity<List<Usuario>> obtenerUsuarios () {
		List<Usuario> usuarios = usuarioConsulta.obtenerUsuarios();
		return usuarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/us/usuario")
	@Operation(summary = "obtenerUsuariosPorAlbumPermiso: Obtiene todos los usuarios que tienen un permiso determinado respecto a un album especifico")
	public ResponseEntity<List<Usuario>> obtenerUsuariosPorAlbumPermiso (@RequestParam String claveTipoPermiso, @RequestParam Integer idAlbum) {
		List<Usuario> usuarios = usuarioConsulta.obtenerUsuariosPorAlbumPermiso(claveTipoPermiso, idAlbum);
		return usuarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(usuarios);
	}
}
