package com.co.wchallenge.dominio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Comentario;
import com.co.wchallenge.dominio.repositorio.consulta.ComentarioConsultaRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComentarioConsulta {
	
	private final ComentarioConsultaRepositorio comentarioConsultaRepositorio;

	public List<Comentario> obtenerComentarios(Optional<String> correo, Optional<String> nombreComentario) {
		return comentarioConsultaRepositorio.obtenerComentarios(correo, nombreComentario);
	}

}
