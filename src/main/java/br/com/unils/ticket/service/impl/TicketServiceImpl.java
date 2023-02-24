package br.com.unils.ticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.model.TicketModel;
import br.com.unils.ticket.repository.TicketRepository;
import br.com.unils.ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public TicketModel findById(Long id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	public TicketModel save(TicketModel obj) {
		return ticketRepository.save(obj);
	}

	@Override
	public List<TicketModel> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		ticketRepository.deleteById(id);
	}

	public void enableOrDisableTicket(boolean status, Long cod) {
		ticketRepository.EnableOrDisableTicket(status, cod);
	}

	public List<TicketModel> findTicketsEnableOrDisable(Boolean status) {
		return ticketRepository.findAllTicketsEnableOrDisable(status);
	}

	public List<TicketModel> findTicketsActivesRoleFunc(Boolean status, Long id) {
		return ticketRepository.findAllTicketsActivesOrDisableOfFunc(status, id);
	}
}
