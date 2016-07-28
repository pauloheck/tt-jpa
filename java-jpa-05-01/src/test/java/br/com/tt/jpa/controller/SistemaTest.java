package br.com.tt.jpa.controller;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.tt.jpa.model.Cliente;

public class SistemaTest {

	@Test
	public void testSalvar() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpateste");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Cliente cliente = new Cliente();
		cliente.setNome("sss");
		em.persist(cliente);
		em.getTransaction().commit();

		em.find(Cliente.class, 1L);
		System.out.println(em.find(Cliente.class, 1L).getNome());

	}

}
