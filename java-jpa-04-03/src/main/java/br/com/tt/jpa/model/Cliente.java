package br.com.tt.jpa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private BigDecimal valor;
	
	

	public Cliente() {
		super();
	}

	


	public Cliente(String nome, String cnpj, BigDecimal valor) {
		super(nome);
		this.cnpj = cnpj;
		this.valor = valor;
	}




	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
