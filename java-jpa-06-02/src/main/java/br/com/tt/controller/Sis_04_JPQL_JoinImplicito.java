package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.model.Telefone;

public class Sis_04_JPQL_JoinImplicito {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		String consulta = "SELECT t FROM Telefone t ";
		consulta += "WHERE t.cliente.nome = :nome ";

		TypedQuery<Telefone> query = em.createQuery(consulta, Telefone.class);
		query.setParameter("nome", "Roberto Santos");
		List<Telefone> telefones = query.getResultList();
		telefones.forEach(t->print(t));

	}

	private static void print(Telefone telefone) {
		System.out.println(telefone.getTelefone());
	}
}
