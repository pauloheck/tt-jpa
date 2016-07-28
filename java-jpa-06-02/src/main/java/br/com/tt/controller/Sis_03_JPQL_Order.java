package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Sis_03_JPQL_Order {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		String consulta = "SELECT c.nome FROM Cliente c ORDER BY c.nome";
		TypedQuery<String> query = em.createQuery(consulta, String.class);
		List<String> nomes = query.getResultList();

		nomes.forEach(nome -> print(nome));
	}

	private static void print(String nome) {
		System.out.println(nome);
	}
}
