package br.com.tt.jpa.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Sexo;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Iniciando o Sistema!");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
	
		cliente.setNome("Juca Lima");
		cliente.setCpf("00000000");
		cliente.setDataNasc(new Date());
		cliente.setSexo(Sexo.M);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.persist(new Cliente("Maria"));
		em.persist(new Cliente("Carlos","454545"));
		cliente.setNome("Camila");
		cliente.setSexo(Sexo.F);
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println(cliente.getNome());
		System.out.println("Cliente cadastrado com sucesso!");
		
	}

}
