package br.com.tt.jpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "cliente.list", query = "SELECT c FROM Cliente c"),
		@NamedQuery(name = "cliente.count", query = "SELECT count(c) FROM Cliente c") })
@NamedNativeQuery(name = "native.cliente.list", query = "SELECT * FROM cliente", resultClass = Cliente.class)
public class Cliente {

	public static String LIST = "cliente.list";
	public static String NATIVE_LIST = "native.cliente.list";
	public static String COUNT = "cliente.count";

	@Id
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
	@GeneratedValue(generator = "cliente_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String nome;

	private String cpfCnpj;

	@Temporal(TemporalType.DATE)
	private Date dataNasc;

	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH })
	private List<Telefone> telefones;

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public void addTelefone(Telefone telefone) {
		if (telefones == null) {
			telefones = new ArrayList<Telefone>();
		}
		telefones.add(telefone);
		telefone.setCliente(this);
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

}
