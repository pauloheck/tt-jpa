package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Curso;
import br.com.tt.jpa.model.CursoId;

public class Sistema {
	private static EntityManager em = null;

	public static void main(String[] args) {
		System.out.println("Sistema");
	

		getEm().getTransaction().begin();;
		getEm().persist(getCurso());
		getEm().getTransaction().commit();
		

	}
	
	private static Curso getCurso(){
		Curso curso = new Curso();
		
		CursoId id = new CursoId();
		id.setCodigoCurso("jpa");
		id.setVersao(1);
		curso.setId(id);
		
		curso.setCurso("JPA");
		curso.setValor(250D);
		
		return curso;
	}

	private static EntityManager getEm() {
		if (em == null) {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("pu_jpa");
			em = emf.createEntityManager();
		}
		return em;
	}
}
