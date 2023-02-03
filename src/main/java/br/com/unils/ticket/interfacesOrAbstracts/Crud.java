package br.com.unils.ticket.interfacesOrAbstracts;

import java.util.List;

public interface Crud<T> {

	public T findById(Long id);

	public T save(T obj);

	public List<T> findAll();

	public void remove(Long id);
}
