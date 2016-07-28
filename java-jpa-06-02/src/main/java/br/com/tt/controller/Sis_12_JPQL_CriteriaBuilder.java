package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.tt.jpa.model.Cliente;

public class Sis_12_JPQL_CriteriaBuilder {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Cliente> criteriaquery = criteriaBuilder
				.createQuery(Cliente.class);
		Root<Cliente> from = criteriaquery.from(Cliente.class);

		ParameterExpression<String> parameterNome = criteriaBuilder
				.parameter(String.class, "nome");

		Predicate predicate = criteriaBuilder.equal(from.get("nome"),
				parameterNome);

		criteriaquery.multiselect(from.get("id"), from.get("nome"))
				.where(criteriaBuilder.and(predicate));

		TypedQuery<Cliente> typeQuery = em.createQuery(criteriaquery);
		typeQuery.setParameter("nome", "Roberto Santos");
		
		List<Cliente> result = typeQuery.getResultList();

		result.forEach(c -> print(c));
	}

	private static void print(Cliente c) {
		System.out.println(c.getNome());
	}
}
