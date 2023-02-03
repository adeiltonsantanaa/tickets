package br.com.unils.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unils.ticket.interfacesOrAbstracts.CrudControllerAbstract;
import br.com.unils.ticket.model.TicketModel;
import br.com.unils.ticket.service.TicketService;

@RestController
@RequestMapping(value = "/api/ticket")
public class TicketController extends CrudControllerAbstract<TicketModel> {

	@Autowired
	private TicketService ticketService;

	@Override
	public TicketModel findById(Long id) {
		return ticketService.findById(id);
	}

	@Override
	public TicketModel save(TicketModel obj) {
		return ticketService.save(obj);
	}

	@Override
	public List<TicketModel> findAll() {
		return ticketService.findAll();
	}

	@Override
	public void remove(Long id) {
		ticketService.remove(id);
	}

}
