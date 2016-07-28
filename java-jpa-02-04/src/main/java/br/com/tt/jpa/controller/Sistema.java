package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Endereco;
import br.com.tt.jpa.model.Pessoa;

public class Sistema {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(getPessoa());
		em.getTransaction().commit();
		em.close();
	}
	
	private static Pessoa getPessoa(){
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Carlos");
		pessoa.setCpf("544545454");
		pessoa.setEndereco(getEndereco());
		return pessoa;
	}

	private static Endereco getEndereco() {
		Endereco endereco = new Endereco();
		endereco.setCidade("Porto Alegre");
		endereco.setRua("Rua Felipe de Noronha");
		return endereco;
	}
	
}
