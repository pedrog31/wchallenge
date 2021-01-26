package com.co.wchallenge.dominio.repositorio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Comentario;

public interface ComentarioConsultaRepositorio {

	List<Comentario> obtenerComentarios(Optional<String> correo, Optional<String> nombreComentario);

}
