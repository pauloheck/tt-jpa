package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.jetty.security.authentication.ClientCertAuthenticator;

import br.com.tt.jpa.model.Cliente;

public class Sis_04_remove {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		System.out.println("Cliente codigo "+cliente.getId());
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		System.out.println("Cliente codigo Removido "+cliente.getId());
	}

}
