package com.co.wchallenge.dominio.unitaria.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.co.wchallenge.dominio.modelo.Permiso;
import com.co.wchallenge.dominio.modelo.PermisoGestor;
import com.co.wchallenge.dominio.modelo.PermisoLector;
import com.co.wchallenge.dominio.modelo.PermisoSeguidor;

class PermisoTest {
	
	private static final Permiso PERMISO_GESTOR = new PermisoGestor();
	private static final Permiso PERMISO_SEGUIDOR = new PermisoSeguidor();
	private static final Permiso PERMISO_LECTOR = new PermisoLector();

	@Test
	void gestorPuedeAgregarPermisos() {
		assertTrue(PERMISO_GESTOR.puedeCrearPermiso(PERMISO_GESTOR));
		assertTrue(PERMISO_GESTOR.puedeCrearPermiso(PERMISO_SEGUIDOR));
		assertTrue(PERMISO_GESTOR.puedeCrearPermiso(PERMISO_LECTOR));
	}

	@Test
	void seguidorPuedeCompartir() {
		assertTrue(PERMISO_SEGUIDOR.puedeCrearPermiso(PERMISO_LECTOR));
	}

	@Test
	void seguidorNoPuedeAgregarPermisos() {
		assertFalse(PERMISO_SEGUIDOR.puedeCrearPermiso(PERMISO_GESTOR));
		assertFalse(PERMISO_SEGUIDOR.puedeCrearPermiso(PERMISO_SEGUIDOR));
	}

	@Test
	void lectorNoPuedeAgregarPermisos() {
		assertFalse(PERMISO_LECTOR.puedeCrearPermiso(PERMISO_GESTOR));
		assertFalse(PERMISO_LECTOR.puedeCrearPermiso(PERMISO_SEGUIDOR));
		assertFalse(PERMISO_LECTOR.puedeCrearPermiso(PERMISO_LECTOR));
	}
}
