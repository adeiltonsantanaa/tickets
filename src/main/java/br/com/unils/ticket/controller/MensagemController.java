package br.com.unils.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unils.ticket.interfacesOrAbstracts.CrudControllerAbstract;
import br.com.unils.ticket.model.MensagemModel;
import br.com.unils.ticket.service.MensagemService;

@RestController
@RequestMapping(value = "/api/mensagem")
public class MensagemController extends CrudControllerAbstract<MensagemModel> {

	@Autowired
	private MensagemService mensagemService;
	
	@Override
	public MensagemModel findById(@PathVariable Long id) {
		return mensagemService.findById(id);
	}

	@Override
	public MensagemModel save(@RequestBody MensagemModel obj) {
		return mensagemService.save(obj);
	}

	@Override
	public List<MensagemModel> findAll() {
		return mensagemService.findAll();
	}

	@Override
	public void remove(@PathVariable Long id) {
		mensagemService.remove(id);
	}

	

}
