package br.com.tt.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sistema {
	public static void main(String... args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// em.persist(getEstado"RS","Porto Alegre"));
		em.persist(getEstado("BB", "cccccc", "ddddd"));

		em.getTransaction().commit();
	}

	private static Estado getEstado(String estado, String... cidades) {
		Estado est = new Estado(estado);
		for (String cidade : cidades) {
			new Cidade(cidade, est);
		}
		return est;
	}

}
