package com.co.wchallenge.sistema.excepciones;

import java.util.ArrayList;
import java.util.List;

import com.co.wchallenge.sistema.utilidades.ErrorTecnico;

public class ExcepcionTecnica extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final List<ErrorTecnico> erroresTecnicos;

	public ExcepcionTecnica(List<ErrorTecnico> erroresTecnicos) {
		this.erroresTecnicos = erroresTecnicos;
	}

	public ExcepcionTecnica (ErrorTecnico errorTecnico) {
		super(errorTecnico.getMensaje());
		this.erroresTecnicos = new ArrayList<>();
		erroresTecnicos.add(errorTecnico);
	}

	public List<ErrorTecnico> getErroresTecnicos () {
		return erroresTecnicos;
	}
}
