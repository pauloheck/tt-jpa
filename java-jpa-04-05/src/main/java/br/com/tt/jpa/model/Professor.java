package br.com.tt.jpa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String pisPasep;
	private BigDecimal salario;

	public Professor() {
		super();
	}

	public Professor(String nome, String pisPasep, BigDecimal salario) {
		super(nome);
		this.pisPasep = pisPasep;
		this.salario = salario;
	}

	public Professor(String nome, String cpf, String pisPasep,
			BigDecimal salario) {
		super(nome, cpf);
		this.pisPasep = pisPasep;
		this.salario = salario;
	}

	public String getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
