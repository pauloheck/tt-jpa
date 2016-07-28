package br.com.tt.jpa.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Aluno;
import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Pessoa;
import br.com.tt.jpa.model.Professor;

public class Sistema {
	static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("pu_jpa");
	static EntityManager em = emf.createEntityManager();
	public static void main(String[] args) {

		Pessoa p1 = new Pessoa("Carlos Silva");
		salvar(p1);
		Cliente c1 = new Cliente("Maria Santos", "25454545",
				new BigDecimal(1000));
		salvar(c1);

		salvar(new Pessoa("Calos Ferreira", "59645785545"));

		Professor professor = new Professor("Zé do Java", "5645454578", "54878",
				new BigDecimal(15850));
		salvar(professor);

		Aluno aluno = new Aluno();
		aluno.setNome("Ana Carla");
		aluno.setCurso("Java JPA");
		aluno.setCpf("52485748457");
		salvar(aluno);

		em.close();
	}

	private static void salvar(Pessoa pessoa) {
	

		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
	}
}
