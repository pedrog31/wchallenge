package com.co.wchallenge.dominio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Foto;
import com.co.wchallenge.dominio.repositorio.consulta.FotoConsultaRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FotoConsulta {

	private final FotoConsultaRepositorio fotoConsultaRepositorio;

	public List<Foto> obtenerFotos(Optional<Integer> idUsuario) {
		return fotoConsultaRepositorio.obtenerFotos(idUsuario);
	}
}
