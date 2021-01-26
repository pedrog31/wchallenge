package com.co.wchallenge.integracion.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.servicio.PermisoServicio;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PermisoRest {
	
	private final PermisoServicio permisoServicio;
	
	@PostMapping("/us/permiso")
	private Permiso crearPermiso (@RequestParam String claveTipoPermiso, @RequestParam Integer idAlbum,
			@RequestParam Integer idUsuario) {
		return permisoServicio.crearPermiso(claveTipoPermiso, idAlbum, idUsuario);
	}
}
