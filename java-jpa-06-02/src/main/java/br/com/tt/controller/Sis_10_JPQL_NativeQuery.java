package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.tt.jpa.model.Cliente;

public class Sis_10_JPQL_NativeQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		// Query query = em.createNamedQuery(Cliente.NATIVE_LIST);
		Query query = em.createNativeQuery("SELECT * FROM cliente",
				Cliente.class);
		List<Cliente> clientes = query.getResultList();
		System.out.println(clientes.size());
		for (Cliente cliente : clientes) {

			System.out.println(cliente.getNome());
		}

	}

	private static void print(Cliente c) {
		System.out.println(c.getNome());
	}
}
