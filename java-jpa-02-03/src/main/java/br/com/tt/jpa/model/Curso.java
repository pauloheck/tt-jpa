package br.com.tt.jpa.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Curso {

	@EmbeddedId
	private CursoId id;

	private String curso;
	
	private Double valor;



	public CursoId getId() {
		return id;
	}

	public void setId(CursoId id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}



}
