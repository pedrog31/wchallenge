package com.co.wchallenge.dominio.servicio;

import java.util.List;
import java.util.Optional;

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
	private final List<Permiso> permisos;

	public Permiso crearPermiso(String claveTipoPermiso, Integer idAlbum, Integer idUsuario, Integer idUsuarioCreador) throws ExcepcionNegocio {
		Permiso permiso = this.obtenerPermiso(claveTipoPermiso);
		this.validarCreacionPermisos(permiso, idAlbum, idUsuario, idUsuarioCreador);
		permisoServicioRepositorio.crearPermiso(claveTipoPermiso, idAlbum, idUsuario);
		return permiso;
	}

	public void eliminarPermiso(Integer idAlbum, Integer idUsuario, Integer idUsuarioEliminador) throws ExcepcionNegocio {
		this.validarEliminacionPermisos(idAlbum, idUsuarioEliminador);
		permisoServicioRepositorio.eliminarPermiso(idAlbum, idUsuario);
	}

	private Permiso obtenerPermiso(String claveTipoPermiso) throws ExcepcionNegocio {
		return permisos.stream().filter(per -> per.getClave().equals(claveTipoPermiso)).findFirst()
				.orElseThrow(() -> ExcepcionNegocio.de(Inconsistencia.de(PermisoInconsistenciaEnum.CLAVE)));
	}

	private boolean puedeCrearPermiso(Permiso permisoACrear, Integer idAlbum, Integer idUsuarioCreador) {
		Optional<Permiso> permisoUsuarioCreadorOp = permisoConsulta.buscarPermiso(idAlbum, idUsuarioCreador);
		if (permisoUsuarioCreadorOp.isEmpty())
			return false;
		Permiso permisoUsuarioCreador = permisoUsuarioCreadorOp.get();
		return permisoUsuarioCreador.puedeCrearPermiso(permisoACrear);
	}

	private void validarCreacionPermisos(Permiso permisoACrear, Integer idAlbum, Integer idUsuario,
			Integer idUsuarioCreador) throws ExcepcionNegocio {
		if (this.puedeCrearPermiso(permisoACrear, idAlbum, idUsuario) || albumConsulta.esDueno(idAlbum, idUsuarioCreador))
			return;
		throw ExcepcionNegocio.de(Inconsistencia.de(PermisoInconsistenciaEnum.CREACION));
	}

	private void validarEliminacionPermisos(Integer idAlbum, Integer idUsuarioEliminador) throws ExcepcionNegocio {
		Optional<Permiso> permisoUsuarioEliminadorOp = permisoConsulta.buscarPermiso(idAlbum, idUsuarioEliminador);
		boolean tienePermiso = permisoUsuarioEliminadorOp.isPresent() && permisoUsuarioEliminadorOp.get().isAgregarEliminarPermisos();
		if (!tienePermiso && !albumConsulta.esDueno(idAlbum, idUsuarioEliminador))
			throw ExcepcionNegocio.de(Inconsistencia.de(PermisoInconsistenciaEnum.ELIMINACION));
	}

}
