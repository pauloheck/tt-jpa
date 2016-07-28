package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.model.Cliente;

public class Sis_02_JPQL_consultaComParametro {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		String consulta = "SELECT c FROM Cliente c WHERE c.nome = :nome";
		
		TypedQuery<Cliente> query = em.createQuery(consulta, Cliente.class);
		query.setParameter("nome", "Roberto Santos");
		
		List<Cliente> clietes = query.getResultList();
		clietes.forEach(c->System.out.println(c.getNome()));
		
	}
}
