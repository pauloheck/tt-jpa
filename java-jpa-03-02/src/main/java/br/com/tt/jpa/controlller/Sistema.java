package br.com.tt.jpa.controlller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Aluno;
import br.com.tt.jpa.model.Curso;

public class Sistema {
	public static void main(String[] args) {
		Curso curso = new Curso();
		Aluno aluno = new Aluno();

		curso.setCurso("JPA Web");
		curso.setDescricao("JAVA JSF");
		curso.addAluno(aluno);

		aluno.setNome("Juca Costa Alves");
		aluno.setCpf("545454878578517");
		aluno.addCurso(curso);
		

		salvar(curso);

	}

	private static void salvar(Object object) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");

		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(object);
		transaction.commit();
	}
}
