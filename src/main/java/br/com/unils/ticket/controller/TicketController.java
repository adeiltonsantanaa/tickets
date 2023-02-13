package br.com.unils.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public TicketModel findById(@PathVariable Long id) {
		return ticketService.findById(id);
	}

	@Override
	public TicketModel save(@RequestBody TicketModel obj) {
		return ticketService.save(obj);
	}

	@Override
	public List<TicketModel> findAll() {
		return ticketService.findAll();
	}

	@Override
	public void remove(@PathVariable Long id) {
		ticketService.remove(id);
	}

	@PutMapping(value = "/disable/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void disableTicket(@PathVariable Long id) {
		ticketService.enableOrDisableTicket(false, id);
	}

	@PutMapping(value = "/enable/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void enableTicket(@PathVariable Long id) {
		ticketService.enableOrDisableTicket(true, id);
	}

	@GetMapping(value = "/todos/ativos")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TicketModel> findTicketsActives() {
		return ticketService.findTicketsEnableOrDisable(true);
	}
	
	@GetMapping(value = "/todos/disable")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TicketModel> findTicketsDisable() {
		return ticketService.findTicketsEnableOrDisable(false);
	}

	@GetMapping(value = "/todos/ativos/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TicketModel> findTicketsActivesRoleFun(@PathVariable Long id) {
		return ticketService.findTicketsActivesRoleFunc(true, id);
	}
	@GetMapping(value = "/todos/disable/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TicketModel> findTicketsDisableRoleFun(@PathVariable Long id) {
		return ticketService.findTicketsActivesRoleFunc(false, id);
	}

}
