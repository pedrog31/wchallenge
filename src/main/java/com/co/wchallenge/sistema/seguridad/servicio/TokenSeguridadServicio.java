package com.co.wchallenge.sistema.seguridad.servicio;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.co.wchallenge.dominio.modelo.Usuario;
import com.co.wchallenge.sistema.constantes.TecnicaInconsistenciaEnum;
import com.co.wchallenge.sistema.excepciones.ExcepcionTecnica;
import com.co.wchallenge.sistema.seguridad.modelo.UsuarioDetalle;
import com.co.wchallenge.sistema.utilidades.ErrorTecnico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TokenSeguridadServicio  {

	public static final String ADMINISTRADOR_ROL = "A";
	public static final String USUARIO_ROL = "U";
	public static final String USUARIO_ID = "I";
	
	@Value("${seguridad.token.firma}")
	private String claveFirmaToken;
	
	@Value("${seguridad.token.tiempo-vida-segundos}")
	private Integer tiempoVidaSegundosToken;

	public UsuarioDetalle obtenerAutenticacionPersona (String token) {
    	Claims claims = this.obtenerClaimsToken(token);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (claims.containsKey(ADMINISTRADOR_ROL))
        	authorities.add(new SimpleGrantedAuthority(ADMINISTRADOR_ROL));
        if (claims.containsKey(USUARIO_ROL))
        	authorities.add(new SimpleGrantedAuthority(USUARIO_ROL));
        Integer idPersona =  Integer.parseInt(claims.get(USUARIO_ID).toString());
		return new UsuarioDetalle(authorities, idPersona);
    }

	private Claims obtenerClaimsToken(String token) {
        return Jwts.parser()
                .setSigningKey(claveFirmaToken)
                .parseClaimsJws(token)
                .getBody();
    }
    
    public String obtenerTokenPersona(Optional<Usuario> usuarioDominio) {
        if (usuarioDominio.isEmpty())
        	throw new ExcepcionTecnica(ErrorTecnico.de(TecnicaInconsistenciaEnum.USUARIO_INEXISTENTE));
        return this.obtenerTokenPersona(usuarioDominio.get());
	}
    
    public String obtenerTokenPersona(Usuario usuarioDominio) {
        Claims claims = Jwts.claims();
        claims.put(USUARIO_ID, usuarioDominio.getId());
        claims.put(usuarioDominio.getId().equals(1) ? ADMINISTRADOR_ROL : USUARIO_ROL, true);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tiempoVidaSegundosToken * 1000))
                .signWith(SignatureAlgorithm.HS256, claveFirmaToken)
                .compact();
	}
}
