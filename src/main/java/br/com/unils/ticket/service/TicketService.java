package br.com.unils.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.interfacesOrAbstracts.Crud;
import br.com.unils.ticket.model.TicketModel;
import br.com.unils.ticket.repository.TicketRepository;

@Service
public class TicketService implements Crud<TicketModel> {

	
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
}
