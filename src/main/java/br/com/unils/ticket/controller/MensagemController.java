package br.com.unils.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public MensagemModel findById(Long id) {
		return mensagemService.findById(id);
	}

	@Override
	public MensagemModel save(MensagemModel obj) {
		return mensagemService.save(obj);
	}

	@Override
	public List<MensagemModel> findAll() {
		return mensagemService.findAll();
	}

	@Override
	public void remove(Long id) {
		mensagemService.remove(id);
	}

	

}
