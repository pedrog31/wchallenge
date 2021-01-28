package com.co.wchallenge.integracion.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.wchallenge.dominio.consulta.PermisoConsulta;
import com.co.wchallenge.dominio.excepcion.ExcepcionNegocio;
import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.servicio.PermisoServicio;
import com.co.wchallenge.sistema.seguridad.modelo.UsuarioDetalle;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PermisoRest {

	private final PermisoServicio permisoServicio;
	private final PermisoConsulta permisoConsulta;
	
	@GetMapping("/us/permiso")
	private List<Permiso> obtenerPermisos() throws ExcepcionNegocio {
		return permisoConsulta.obtenerPermisos();
	}
	
	@PostMapping("/us/permiso")
	private Permiso crearPermiso (@RequestParam String claveTipoPermiso, @RequestParam Integer idAlbum,
			@RequestParam Integer idUsuario) throws ExcepcionNegocio {
		Integer idUsuarioCreador = UsuarioDetalle.obtenerUsuarioActual().get().getIdUsuario();
		return permisoServicio.crearPermiso(claveTipoPermiso, idAlbum, idUsuario, idUsuarioCreador);
	}
	
	@DeleteMapping("/us/permiso")
	private void eliminarPermiso (@RequestParam Integer idAlbum,	@RequestParam Integer idUsuario) throws ExcepcionNegocio {
		Integer idUsuarioEliminador = UsuarioDetalle.obtenerUsuarioActual().get().getIdUsuario();
		permisoServicio.eliminarPermiso(idAlbum, idUsuario, idUsuarioEliminador);
	}
}
