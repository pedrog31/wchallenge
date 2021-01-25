package com.co.wchallenge.dominio.consulta;

import java.util.List;

import com.co.wchallenge.dominio.modelo.Usuario;
import com.co.wchallenge.dominio.repositorio.consulta.UsuarioConsultaRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioConsulta {
	
	private final UsuarioConsultaRepositorio usuarioRepositorio;

	public List<Usuario> obtenerUsuarios() {
		return usuarioRepositorio.obtenerUsuarios();
	}

}
