package br.com.tt.jpa.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tt.jpa.dao.ClienteDao;
import br.com.tt.jpa.model.Cliente;
import br.com.tt.jpa.model.Sexo;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Iniciando o Sistema!");
		Cliente cliente = new Cliente();
		cliente.setNome("Juca Lima");
		cliente.setCpf("123456");
		cliente.setDataNasc(new Date());
		cliente.setSexo(Sexo.M);
		
		new ClienteDao().salvar(cliente);
		
		System.out.println(cliente.getNome());
		System.out.println("Cliente cadastrado com sucesso!");
		
	}

}
