package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Telefone;
import br.com.tt.pet.exception.TelefoneException;
import br.com.tt.pet.util.ValidaTelefone;

public class Sistema {
	public    EntityManager em;
	 
	 public   void setEntityManager(){
		  EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("pu_jpa");
		 em = emf.createEntityManager();
	 }
	
//	public static void main(String[] args) {
//		 setEntityManager();
//		//Inicio Tela
//		Cliente cliente = new Cliente();
//		cliente.setNome("Maria Costa Alves");
//		Telefone telefone = new Telefone();
//		telefone.setDdd("51");
//		telefone.setNumero("2356784599");
//		cliente.addTelefone(telefone);
//		// Fim Tela
//		
//		try {
//			ValidaTelefone.valida(telefone.getDdd(), telefone.getNumero());
//			salvar(cliente);
//		} catch (TelefoneException e) {
//		System.out.println(e.getMessage());
//		}
//		
//		System.out.println(buscar(-1L).getNome());
//		
//	}
//
//	
	public  void salvar(Cliente object) {

		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
	}
	
	public  Cliente buscar(Long id){
		
		return em.find(Cliente.class, id);
	}

}
