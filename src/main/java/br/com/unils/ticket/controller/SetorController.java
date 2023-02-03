package br.com.unils.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unils.ticket.interfacesOrAbstracts.CrudControllerAbstract;
import br.com.unils.ticket.model.SetorModel;
import br.com.unils.ticket.service.SetorService;

@RestController
@RequestMapping(value = "/api/setor")
public class SetorController extends CrudControllerAbstract<SetorModel> {

	@Autowired
	private SetorService setorService;

	@Override
	public SetorModel findById(@PathVariable Long id) {
		return setorService.findById(id);
	}

	@Override
	public SetorModel save(@RequestBody SetorModel obj) {
		return setorService.save(obj);
	}

	@Override
	public List<SetorModel> findAll() {
		return setorService.findAll();
	}

	@Override
	public void remove(@PathVariable Long id) {
		setorService.remove(id);
	}

}
