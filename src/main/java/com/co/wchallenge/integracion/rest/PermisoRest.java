package com.co.wchallenge.integracion.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.excepcion.ExcepcionNegocio;
import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.servicio.PermisoServicio;
import com.co.wchallenge.sistema.seguridad.modelo.UsuarioDetalle;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PermisoRest {
	
	private final PermisoServicio permisoServicio;
	
	@PostMapping("/us/permiso")
	private Permiso crearPermiso (@RequestParam String claveTipoPermiso, @RequestParam Integer idAlbum,
			@RequestParam Integer idUsuario) throws ExcepcionNegocio {
		Integer idUsuarioCreador = UsuarioDetalle.obtenerUsuarioActual().get().getIdUsuario();
		return permisoServicio.crearPermiso(claveTipoPermiso, idAlbum, idUsuario, idUsuarioCreador);
	}
}
