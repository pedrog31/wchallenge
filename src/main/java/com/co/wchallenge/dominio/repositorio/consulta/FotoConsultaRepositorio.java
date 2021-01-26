package com.co.wchallenge.dominio.repositorio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Foto;

public interface FotoConsultaRepositorio {

	List<Foto> obtenerFotos(Optional<Integer> idUsuario);

}
