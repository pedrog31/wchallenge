package com.co.wchallenge.dominio.servicio;

import java.util.Optional;
import java.util.stream.Stream;

import com.co.wchallenge.dominio.constantes.PermisoInconsistenciaEnum;
import com.co.wchallenge.dominio.consulta.AlbumConsulta;
import com.co.wchallenge.dominio.consulta.PermisoConsulta;
import com.co.wchallenge.dominio.excepcion.ExcepcionNegocio;
import com.co.wchallenge.dominio.modelo.Inconsistencia;
import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.repositorio.servicio.PermisoServicioRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PermisoServicio {
	
	private final PermisoServicioRepositorio permisoServicioRepositorio;
	private final PermisoConsulta permisoConsulta;
	private final AlbumConsulta albumConsulta;
	private final Stream<Permiso> permisos;

	public Permiso crearPermiso(String claveTipoPermiso, Integer idAlbum, Integer idUsuario, Integer idUsuarioCreador) throws ExcepcionNegocio {
		Permiso permiso = this.obtenerPermiso(claveTipoPermiso);
		this.validarCreacionPermisos(permiso, idAlbum, idUsuario, idUsuarioCreador);
		permisoServicioRepositorio.crearPermiso(claveTipoPermiso, idAlbum, idUsuario);
		return permiso;
	}

	private void validarCreacionPermisos(Permiso permisoACrear, Integer idAlbum, Integer idUsuario,
			Integer idUsuarioCreador) throws ExcepcionNegocio {
		Optional<Permiso> permisoUsuarioCreador = permisoConsulta.buscarPermiso(idAlbum, idUsuario);
		if (this.puedeCrearPermiso(permisoACrear, permisoUsuarioCreador) || albumConsulta.esDueño(idAlbum, idUsuarioCreador))
			return;
		throw ExcepcionNegocio.de(Inconsistencia.de(PermisoInconsistenciaEnum.CREACION));
	}

	private boolean puedeCrearPermiso(Permiso permisoACrear, Optional<Permiso> permisoUsuarioCreadorOp) {
		if (permisoUsuarioCreadorOp.isEmpty())
			return false;
		Permiso permisoUsuarioCreador = permisoUsuarioCreadorOp.get();
		if (permisoUsuarioCreador.isAgregarEliminarPermisos()
				|| (permisoACrear.isLeer() && permisoUsuarioCreador.isCompartir()))
			return true;
		return false;
	}

	private Permiso obtenerPermiso(String claveTipoPermiso) throws ExcepcionNegocio {
		return permisos.filter(per -> per.getClave().equals(claveTipoPermiso)).findFirst()
				.orElseThrow(() -> ExcepcionNegocio.de(Inconsistencia.de(PermisoInconsistenciaEnum.CLAVE)));
	}

}
