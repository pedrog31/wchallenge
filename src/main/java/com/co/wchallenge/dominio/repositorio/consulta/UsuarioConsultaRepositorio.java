package com.co.wchallenge.dominio.repositorio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Usuario;

public interface UsuarioConsultaRepositorio {

	List<Usuario> obtenerUsuarios();

	Optional<Usuario> obtenerUsuario(String correo, Integer identificador);

}
