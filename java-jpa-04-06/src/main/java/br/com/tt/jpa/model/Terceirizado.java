package br.com.tt.jpa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Terceirizado extends Professor {

	private static final long serialVersionUID = 1L;
	private String empresa;
	private String cnpj;

	public Terceirizado() {
		super();
	}

	public Terceirizado(String nome, String pisPasep, BigDecimal salario,
			String empresa, String cnpj) {
		super(nome, pisPasep, salario);
		this.empresa = empresa;
		this.cnpj = cnpj;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
