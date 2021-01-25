package com.co.wchallenge.integracion.persistencia.rest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.co.wchallenge.dominio.modelo.Usuario;
import com.co.wchallenge.dominio.repositorio.consulta.UsuarioConsultaRepositorio;
import com.co.wchallenge.integracion.persistencia.rest.constructor.UsuarioConstructor;
import com.co.wchallenge.integracion.persistencia.rest.modelo.UserDTO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UsuarioConsultaRepositorioRest implements UsuarioConsultaRepositorio {

	private final RestTemplate plantillaRest;

	@Override
	public List<Usuario> obtenerUsuarios() {
		return Arrays.asList(
				plantillaRest.getForObject("/users", UserDTO[].class))
					.stream().map(UsuarioConstructor::convertirADominio).collect(Collectors.toList());
	}

}
