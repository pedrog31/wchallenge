package com.co.wchallenge.sistema.seguridad.servicio;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.consulta.UsuarioConsulta;
import com.co.wchallenge.dominio.modelo.Usuario;
import com.co.wchallenge.sistema.seguridad.modelo.UsuarioSeguridad;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/au/")
@AllArgsConstructor
public class AutenticacionRest {
	
	private final TokenSeguridadServicio tokenSeguridadServicio;
	private final UsuarioConsulta usuarioConsulta;

	@PostMapping("autenticacion")
	public Map<String, Object> autenticarPersona(
			@Parameter(description = "REQUERIDO 'correoElectronico' 'contrasena'") @RequestBody UsuarioSeguridad usuario) {
		Optional<Usuario> usuarioDominio = usuarioConsulta.obtenerUsuario(usuario.getCorreo(), Integer.parseInt(usuario.getContrasena()));
		return Collections.singletonMap("token", tokenSeguridadServicio.obtenerTokenPersona(usuarioDominio));
	}
	
}
