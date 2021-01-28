package com.co.wchallenge.dominio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Usuario;
import com.co.wchallenge.dominio.repositorio.consulta.UsuarioConsultaRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioConsulta {
	
	private final UsuarioConsultaRepositorio usuarioRepositorio;
	private final PermisoConsulta permisoConsulta;

	public List<Usuario> obtenerUsuarios() {
		return usuarioRepositorio.obtenerUsuarios();
	}

	public Optional<Usuario> obtenerUsuario(String correo, Integer identificador) {
		return usuarioRepositorio.obtenerUsuario(correo, identificador);
	}

	public List<Usuario> obtenerUsuariosPorAlbumPermiso(String claveTipoPermiso, Integer idAlbum) {
		List<Integer> idUsuarios = permisoConsulta.obtenerUsuariosConPermisos(claveTipoPermiso, idAlbum);
		return usuarioRepositorio.obtenerUsuarios(idUsuarios);
	}

}
