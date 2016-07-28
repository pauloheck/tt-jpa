package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Sis_06_JPQL_FuncoesMatematicas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		String consl = "SELECT SUM(c.id) FROM Cliente c";
		TypedQuery<Number> query = em.createQuery(consl, Number.class);
		Number soma = query.getSingleResult();

		consl = "SELECT MAX(c.id) FROM Cliente c";
		query = em.createQuery(consl, Number.class);
		Number max = query.getSingleResult();

		consl = "SELECT MIN(c.id) FROM Cliente c";
		query = em.createQuery(consl, Number.class);
		Number min = query.getSingleResult();

		consl = "SELECT COUNT(c.id) FROM Cliente c";
		query = em.createQuery(consl, Number.class);
		Number count = query.getSingleResult();

		consl = "SELECT AVG(c.id) FROM Cliente c";
		query = em.createQuery(consl, Number.class);
		Number avg = query.getSingleResult();

		System.out.println("Soma: " + soma);
		System.out.println("Maximo: " + max);
		System.out.println("Minimo: " + min);
		System.out.println("Contagem: " + count);
		System.out.println("Media: " + avg);
	}
}
