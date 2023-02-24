package br.com.unils.ticket.service;

import br.com.unils.ticket.interfacesOrAbstracts.Crud;
import br.com.unils.ticket.model.FuncionariosModel;

public interface FuncionariosService extends Crud<FuncionariosModel> {

	public FuncionariosModel verifyEmail(String email);
}
