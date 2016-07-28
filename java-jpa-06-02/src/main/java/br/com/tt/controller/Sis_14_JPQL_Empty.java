package br.com.tt.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.model.Cliente;

public class Sis_14_JPQL_Empty {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		String consulta = "SELECT DISTINCT c.nome FROM Cliente c ";
		consulta +=" WHERE c.telefones IS NOT EMPTY";
		TypedQuery<String> query = em.createQuery(consulta, String.class);

		query.getResultList().forEach(nome -> print(nome));

	}

	private static void print(String nome) {
		System.out.println(nome);

	}

}
