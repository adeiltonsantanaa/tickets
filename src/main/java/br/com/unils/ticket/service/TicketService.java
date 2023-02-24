package br.com.unils.ticket.service;

import java.util.List;

import br.com.unils.ticket.interfacesOrAbstracts.Crud;
import br.com.unils.ticket.model.TicketModel;

public interface TicketService extends Crud<TicketModel> {

	public void enableOrDisableTicket(boolean status, Long cod);

	public List<TicketModel> findTicketsEnableOrDisable(Boolean status);

	public List<TicketModel> findTicketsActivesRoleFunc(Boolean status, Long id);
}
