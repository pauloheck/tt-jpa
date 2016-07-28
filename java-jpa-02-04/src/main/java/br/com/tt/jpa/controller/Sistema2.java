package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Endereco;
import br.com.tt.jpa.model.Pessoa;

public class Sistema2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(getEndereco());
		em.getTransaction().commit();
		em.close();
	}
	
	private static Pessoa getPessoa(){
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Maria2");
		pessoa.setCpf("254545");
		
		return pessoa;
	}

	private static Endereco getEndereco() {
		Endereco endereco = new Endereco();
		endereco.setCidade("Canoas2");
		endereco.setRua("Rua Centro");
		endereco.setPessoa(getPessoa());
		return endereco;
	}
	
}
