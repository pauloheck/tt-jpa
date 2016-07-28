package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Cliente;

public class Sis_05_sincronizacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		Cliente cliente = em.find(Cliente.class, 1L);

		em.getTransaction().begin();
		em.flush();
		em.getTransaction().commit();

		boolean contains = em.contains(cliente);
		System.out.println("Antes do Clear contains: " + contains);
		em.clear();
		contains = em.contains(cliente);
		System.out.println("Depois do Clear contains: " + contains);

	}
}
