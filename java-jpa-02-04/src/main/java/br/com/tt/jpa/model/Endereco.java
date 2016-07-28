package br.com.tt.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Endereco {
	@Id
	@SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
	private Long id;
	private String rua;
	private String cidade;
	// mapeamento do atributo da classe pessoa
	@OneToOne(mappedBy = "endereco", cascade = { CascadeType.PERSIST,
												 CascadeType.MERGE,
												 CascadeType.REFRESH})
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		pessoa.setEndereco(this);
		this.pessoa = pessoa;
	}

}
