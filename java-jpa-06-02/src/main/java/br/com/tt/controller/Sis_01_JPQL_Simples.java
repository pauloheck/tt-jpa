package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.model.Cliente;

public class Sis_01_JPQL_Simples {
	public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		String consulta = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> query = em.createQuery(consulta,Cliente.class);
		List<Cliente> clientes = query.getResultList();
		
		clientes.forEach(c->System.out.println(c.getNome()));
		
		// Igual a linha anterior 
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente.getNome());
//
//		}
	}
}
