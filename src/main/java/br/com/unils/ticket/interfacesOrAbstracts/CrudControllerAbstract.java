package br.com.unils.ticket.interfacesOrAbstracts;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class CrudControllerAbstract<T> {

	@GetMapping(value = "/buscar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public abstract T findById(Long id);

	@PostMapping(value = "/salvar")
	@ResponseStatus(code = HttpStatus.OK)
	public abstract T save(T obj);
	
	@GetMapping(value = "/todos")
	@ResponseStatus(code = HttpStatus.OK)
	public abstract List<T> findAll();

	@DeleteMapping(value = "/deletar/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public abstract void remove(Long id);
}
