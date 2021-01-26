package com.co.wchallenge.dominio.consulta;

import java.util.List;
import java.util.Optional;

import com.co.wchallenge.dominio.modelo.Album;
import com.co.wchallenge.dominio.repositorio.consulta.AlbumConsultaRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlbumConsulta {
	
	private final AlbumConsultaRepositorio albumConsultaRepositorio;

	public List<Album> obtenerAlbumes(Optional<Integer> idUsuario) {
		return albumConsultaRepositorio.obtenerAlbumes(idUsuario);
	}

}
