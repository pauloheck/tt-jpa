package br.com.tt.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Sexo;

public class ClienteDao implements IDao<Cliente> {

	public void salvar(Cliente cliente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}

	public Cliente buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente buscar(Cliente t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void remover(Long id) {
		// TODO Auto-generated method stub

	}

	public void remover(Cliente t) {
		// TODO Auto-generated method stub

	}

}
