package br.com.unils.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unils.ticket.interfacesOrAbstracts.CrudControllerAbstract;
import br.com.unils.ticket.model.FuncionariosModel;
import br.com.unils.ticket.service.FuncionariosService;

@RestController
@RequestMapping(value = "/api/funcionarios")
public class FuncionariosController extends CrudControllerAbstract<FuncionariosModel> {

	@Autowired
	private FuncionariosService funcionariosService;

	@Override
	public FuncionariosModel findById(@PathVariable Long id) {
		return funcionariosService.findById(id);
	}

	@Override
	public FuncionariosModel save(@RequestBody FuncionariosModel obj) {
		return funcionariosService.save(obj);
	}

	@Override
	public List<FuncionariosModel> findAll() {
		return funcionariosService.findAll();
	}

	@Override
	public void remove(@PathVariable Long id) {
		funcionariosService.remove(id);
	}

}
