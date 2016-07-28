package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Telefone;

public class Sis_02_find {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		Cliente cliente = em.find(Cliente.class, 1L);
		
		Telefone telefone = em.find(Telefone.class, 1L);
		
		System.out.println("Nome do Cliente: " + cliente.getNome());
		System.out.println("Telefone: " + telefone.getTelefone());

	}
}
