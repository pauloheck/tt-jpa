package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.model.Cliente;

public class Sis_16_JPQL_Between {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		String consulta = "SELECT  c.nome FROM Cliente c ";
		consulta +=" WHERE c.id BETWEEN 1 AND 10";
		TypedQuery<String> query = em.createQuery(consulta, String.class);

		query.getResultList().forEach(nome -> print(nome));

	}

	private static void print(String nome) {
		System.out.println(nome);

	}

}
