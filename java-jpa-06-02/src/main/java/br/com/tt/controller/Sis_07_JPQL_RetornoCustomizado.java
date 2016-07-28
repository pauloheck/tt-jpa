package br.com.tt.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.vo.ClienteVO;

public class Sis_07_JPQL_RetornoCustomizado {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pu_jpa");
		EntityManager em = emf.createEntityManager();
		String consulta = "";
		consulta += " SELECT                                        ";
		consulta += " NEW br.com.tt.jpa.vo.ClienteVO (              ";
		consulta += " t.cliente.nome,  CONCAT(t.ddd,t.numero)    ";
		consulta += " )                                             ";
		consulta += "  FROM Telefone t                              ";

		TypedQuery<ClienteVO> query = em.createQuery(consulta, ClienteVO.class);
		List<ClienteVO> clientes = query.getResultList();
		clientes.forEach(c -> print(c));
		System.exit(0);
	}

	private static void print(ClienteVO c) {
		String nome = "Nome: " + c.getNome();
		String telefone = "\t\tTelefone: " + c.getTelefone();
		System.out.println(nome + telefone);
	}
}
