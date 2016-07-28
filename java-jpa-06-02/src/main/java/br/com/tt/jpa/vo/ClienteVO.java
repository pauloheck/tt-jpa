package br.com.tt.jpa.vo;

public class ClienteVO {

	private String nome;
	private String telefone;

	public ClienteVO(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

}
