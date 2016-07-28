package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.model.Cliente;

public class Sis_09_JPQL_NamedQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Cliente> query = em.createNamedQuery(Cliente.LIST,
				Cliente.class);
		query.getResultList().forEach(c -> print(c));

	}

	private static void print(Cliente c) {
		System.out.println(c.getNome());
	}
}
