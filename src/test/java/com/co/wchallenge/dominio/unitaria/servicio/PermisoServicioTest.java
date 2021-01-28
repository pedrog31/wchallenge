package com.co.wchallenge.dominio.unitaria.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import com.co.wchallenge.dominio.constantes.PermisoEnum;
import com.co.wchallenge.dominio.constantes.PermisoInconsistenciaEnum;
import com.co.wchallenge.dominio.consulta.AlbumConsulta;
import com.co.wchallenge.dominio.consulta.PermisoConsulta;
import com.co.wchallenge.dominio.excepcion.ExcepcionNegocio;
import com.co.wchallenge.dominio.modelo.Inconsistencia;
import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.modelo.PermisoGestor;
import com.co.wchallenge.dominio.modelo.PermisoLector;
import com.co.wchallenge.dominio.modelo.PermisoSeguidor;
import com.co.wchallenge.dominio.repositorio.servicio.PermisoServicioRepositorio;
import com.co.wchallenge.dominio.servicio.PermisoServicio;

class PermisoServicioTest {
	
	private static PermisoServicio permisoServicio;
	private static PermisoServicioRepositorio permisoServicioRepositorio;
	private static PermisoConsulta permisoConsulta;
	private static AlbumConsulta albumConsulta;
	private static List<Permiso> permisos;

	@BeforeAll
	public static void iniciarTests() {
		permisoServicioRepositorio = mock(PermisoServicioRepositorio.class);
		permisoConsulta = mock(PermisoConsulta.class);
		albumConsulta = mock(AlbumConsulta.class);
		permisos =  Arrays.asList(
				new PermisoGestor(),
				new PermisoSeguidor(),
				new PermisoLector());
		permisoServicio = new PermisoServicio(permisoServicioRepositorio, permisoConsulta, albumConsulta, permisos);
	}
	
	@Test
	void noPuedeCrearPermisoSinPermisosNiSiendoDuenoTest() {
		when(permisoConsulta.buscarPermiso(1, 1)).thenReturn(Optional.empty());
		when(albumConsulta.esDueno(1, 1)).thenReturn(false);
		try {
			permisoServicio.crearPermiso(PermisoEnum.GESTOR.getClave(), 1, 1, 1);
			fail();
		} catch (ExcepcionNegocio e) {
			assertEquals(1, e.getInconsistencias().size());
			assertTrue(e.getInconsistencias().contains(Inconsistencia.de(PermisoInconsistenciaEnum.CREACION)));
		}
	}
	
	@Test
	void puedeCrearPermisoSinPermisosSiendoDuenoTest() {
		when(permisoConsulta.buscarPermiso(1, 1)).thenReturn(Optional.empty());
		when(albumConsulta.esDueno(1, 1)).thenReturn(true);
		try {
			permisoServicio.crearPermiso(PermisoEnum.GESTOR.getClave(), 1, 1, 1);
		} catch (ExcepcionNegocio e) {
			fail();
		}
	}
	
	@Test
	void puedeCrearPermisoConPermisosSinSerDuenoTest() {
		Permiso permisoSiemprePuedeCrear = mock(Permiso.class);
		when(permisoSiemprePuedeCrear.puedeCrearPermiso(ArgumentMatchers.any())).thenReturn(true);
		when(permisoConsulta.buscarPermiso(1, 1)).thenReturn(Optional.of(permisoSiemprePuedeCrear));
		when(albumConsulta.esDueno(1, 1)).thenReturn(false);
		try {
			permisoServicio.crearPermiso(PermisoEnum.GESTOR.getClave(), 1, 1, 1);
		} catch (ExcepcionNegocio e) {
			fail();
		}
	}
	
	@Test
	void puedeEliminarPermisoConPermisosSinSerDuenoTest() {
		Permiso permisoSiemprePuedeEliminar = mock(Permiso.class);
		when(permisoSiemprePuedeEliminar.isAgregarEliminarPermisos()).thenReturn(true);
		when(permisoConsulta.buscarPermiso(1, 1)).thenReturn(Optional.of(permisoSiemprePuedeEliminar));
		when(albumConsulta.esDueno(1, 1)).thenReturn(false);
		try {
			permisoServicio.eliminarPermiso(1, 1, 1);
		} catch (ExcepcionNegocio e) {
			fail();
		}
	}
	
	@Test
	void puedeEliminarPermisoSinPermisosSiendoDuenoTest() {
		when(permisoConsulta.buscarPermiso(1, 1)).thenReturn(Optional.empty());
		when(albumConsulta.esDueno(1, 1)).thenReturn(true);
		try {
			permisoServicio.eliminarPermiso(1, 1, 1);
		} catch (ExcepcionNegocio e) {
			fail();
		}
	}
	
	@Test
	void puedeEliminarPermisoSinPermisoValidoSiendoDuenoTest() {
		Permiso permisoSiemprePuedeEliminar = mock(Permiso.class);
		when(permisoSiemprePuedeEliminar.isAgregarEliminarPermisos()).thenReturn(false);
		when(permisoConsulta.buscarPermiso(1, 1)).thenReturn(Optional.of(permisoSiemprePuedeEliminar));
		when(albumConsulta.esDueno(1, 1)).thenReturn(true);
		try {
			permisoServicio.eliminarPermiso(1, 1, 1);
		} catch (ExcepcionNegocio e) {
			fail();
		}
	}
	
	@Test
	void noPuedeEliminarPermisoSinPermisosYSinSerDuenoTest() {
		when(permisoConsulta.buscarPermiso(1, 1)).thenReturn(Optional.empty());
		when(albumConsulta.esDueno(1, 1)).thenReturn(false);
		try {
			permisoServicio.eliminarPermiso(1, 1, 1);
			fail();
		} catch (ExcepcionNegocio e) {
			assertEquals(1, e.getInconsistencias().size());
			assertTrue(e.getInconsistencias().contains(Inconsistencia.de(PermisoInconsistenciaEnum.ELIMINACION)));
		}
	}
}
