package br.com.tt.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CursoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String codigoCurso;
	@Column(nullable = false)
	private Integer versao;

	public CursoId() {
		super();
	}

	public CursoId(String codigoCurso, Integer versao) {
		super();
		this.codigoCurso = codigoCurso;
		this.versao = versao;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoCurso == null) ? 0 : codigoCurso.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoId other = (CursoId) obj;
		if (codigoCurso == null) {
			if (other.codigoCurso != null)
				return false;
		} else if (!codigoCurso.equals(other.codigoCurso))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CursoId [codigoCurso=" + codigoCurso + ", versao=" + versao
				+ "]";
	}

}
