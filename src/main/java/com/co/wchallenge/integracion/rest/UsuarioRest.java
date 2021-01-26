package com.co.wchallenge.integracion.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.consulta.UsuarioConsulta;
import com.co.wchallenge.dominio.modelo.Usuario;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UsuarioRest {

	private final UsuarioConsulta usuarioConsulta;
	
	@GetMapping("/ops/usuario")
	private ResponseEntity<List<Usuario>> obtenerUsuarios () {
		List<Usuario> usuarios = usuarioConsulta.obtenerUsuarios();
		return usuarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(usuarios);
	}
}
