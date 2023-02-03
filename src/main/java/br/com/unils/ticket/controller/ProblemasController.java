package br.com.unils.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unils.ticket.interfacesOrAbstracts.CrudControllerAbstract;
import br.com.unils.ticket.model.ProblemasModel;
import br.com.unils.ticket.service.ProblemasService;

@RestController
@RequestMapping(value = "/api/problemas")
public class ProblemasController extends CrudControllerAbstract<ProblemasModel> {

	@Autowired
	private ProblemasService problemasService;

	@Override
	public ProblemasModel findById(Long id) {
		return problemasService.findById(id);
	}

	@Override
	public ProblemasModel save(ProblemasModel obj) {
		return problemasService.save(obj);
	}

	@Override
	public List<ProblemasModel> findAll() {
		return problemasService.findAll();
	}

	@Override
	public void remove(Long id) {
		problemasService.remove(id);
	}

}
