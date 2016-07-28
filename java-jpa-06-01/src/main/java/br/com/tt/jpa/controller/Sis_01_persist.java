package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.jetty.security.authentication.ClientCertAuthenticator;

import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Telefone;

public class Sis_01_persist {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Alex Silva");
		Telefone telefone = new Telefone();
		cliente.addTelefone(telefone);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
		
	}

}
