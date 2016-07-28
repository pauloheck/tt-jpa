package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.model.Cliente;

public class Sis_11_JPQL_ControllerResult {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Cliente> query = em.createNamedQuery(Cliente.LIST,
				Cliente.class);
		
		query.setFirstResult(5);
		query.setMaxResults(10);
		query.getResultList().forEach(c -> print(c));

		
		
	}

	private static void print(Cliente c) {
		System.out.println(c.getNome());
	}

}
