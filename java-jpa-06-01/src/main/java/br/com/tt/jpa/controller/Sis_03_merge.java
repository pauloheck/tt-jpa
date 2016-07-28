package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Cliente;

public class Sis_03_merge {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_jpa");
	EntityManager em = emf.createEntityManager();
	
	Cliente cliente = em.find(Cliente.class, 1L);
	String nome = cliente.getNome();
	cliente.setNome("Roberto Santos");
	em.getTransaction().begin();
	em.merge(cliente);
	em.getTransaction().commit();
	cliente = em.find(Cliente.class, 1L);
	
	String antes = "Nome Cliente antes da Alteração: ";
	System.out.println(antes+nome);
	System.out.println("Nome apos o merge: "+cliente.getNome());
}
}
