package br.com.tt.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.MaterialDidaticoIdClass;
import br.com.tt.jpa.model.MaterialDidaticoPkIdClass;

public class Main {
	public static void main(String[] args) {
		// Cria EntityManager
		EntityManager em = Persistence.createEntityManagerFactory("pu_jpa")
				.createEntityManager();
		
		System.out.println("Iniciando o Sistema");
		// Cria o objeto a ser persistido
		MaterialDidaticoIdClass material = getMaterial();
		// Salva na Base
		salvar(em, material);
		// Dados da PK
		String codigoCurso = material.getCodigoCurso();
		Integer versao = material.getVersao();

		System.out.println("Material cadastrado com sucesso!");
// Classe da PK
		Class<MaterialDidaticoIdClass> clazz = MaterialDidaticoIdClass.class;
		// Cria a PK
		MaterialDidaticoPkIdClass pk = null;
		pk = new MaterialDidaticoPkIdClass(codigoCurso,versao);

		MaterialDidaticoIdClass consulta = em.find(clazz, pk);
		
		System.out.println("Curso da Consulta "+consulta.getCurso());

		em.close();
	}

	private static void salvar(EntityManager em,
			MaterialDidaticoIdClass material) {
		em.getTransaction().begin();
		em.persist(material);
		em.getTransaction().commit();
	}

	private static MaterialDidaticoIdClass getMaterial() {
		MaterialDidaticoIdClass material = new MaterialDidaticoIdClass();
		material.setCodigoCurso("jpa");
		material.setCurso("JPA");
		material.setDuracao(20);
		material.setVersao(2);
		return material;
	}

}
