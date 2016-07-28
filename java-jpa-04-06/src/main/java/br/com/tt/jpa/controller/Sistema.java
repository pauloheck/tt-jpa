package br.com.tt.jpa.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Aluno;
import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Pessoa;
import br.com.tt.jpa.model.Professor;
import br.com.tt.jpa.model.Terceirizado;

public class Sistema {
	static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("pu_jpa");
	static EntityManager em = emf.createEntityManager();
	public static void main(String[] args) {

		Cliente c1 = new Cliente("Maria Santos", "25454545",
				new BigDecimal(1000));
		salvar(c1);


		Professor professor = new Professor("Z� do Java", "5645454578", "54878",
				new BigDecimal(15850));
		salvar(professor);

		Aluno aluno = new Aluno();
		aluno.setNome("Ana Carla");
		aluno.setCurso("Java JPA");
		aluno.setCpf("52485748457");
		salvar(aluno);
		
		Terceirizado terceirizado = new Terceirizado();
		terceirizado.setNome("Jo�o Alves");
		terceirizado.setCpf("asdfasdfa");
		terceirizado.setCnpj("5457548787");
		terceirizado.setEmpresa("BeCode");

		salvar(terceirizado);
		em.close();
	}

	private static void salvar(Pessoa pessoa) {
	

		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
	}
}
