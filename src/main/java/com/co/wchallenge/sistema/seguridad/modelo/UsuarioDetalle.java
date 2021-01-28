package com.co.wchallenge.sistema.seguridad.modelo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.co.wchallenge.sistema.seguridad.servicio.TokenSeguridadServicio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UsuarioDetalle implements UserDetails {

	private static final long serialVersionUID = 732099405152454933L;
	
	public static Optional<UsuarioDetalle> obtenerUsuarioActual() {
		if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UsuarioDetalle) {
			return Optional.of((UsuarioDetalle) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		} else {
			return Optional.empty();
		}
	}
	private List<SimpleGrantedAuthority> authorities;
	
	private Integer idUsuario;

	public UsuarioDetalle(List<SimpleGrantedAuthority> authorities, Integer idUsuario) {
		this.authorities = authorities;
		this.idUsuario = idUsuario;
	}

	public boolean esUsuario() {
		return authorities.stream().anyMatch(
				autority -> autority.getAuthority().equals(TokenSeguridadServicio.USUARIO_ROL));
	}

	public boolean esAdministrador() {
		return authorities.stream().anyMatch(
				autority -> autority.getAuthority().equals(TokenSeguridadServicio.ADMINISTRADOR_ROL));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
