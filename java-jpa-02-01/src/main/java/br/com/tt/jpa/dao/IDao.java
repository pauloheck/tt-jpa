package br.com.tt.jpa.dao;

import java.util.List;

public interface IDao<T> {

	void salvar(T t);

	T buscar(Long id);

	T buscar(T t);

	List<T> consultar();

	void remover(Long id);

	void remover(T t);

}
