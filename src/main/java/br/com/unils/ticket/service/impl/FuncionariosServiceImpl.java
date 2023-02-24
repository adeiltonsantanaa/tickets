package br.com.unils.ticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.model.FuncionariosModel;
import br.com.unils.ticket.repository.FuncionariosRepository;
import br.com.unils.ticket.service.FuncionariosService;

@Service
public class FuncionariosServiceImpl implements FuncionariosService {

	@Autowired
	private FuncionariosRepository funcionariosRepository;

	@Override
	public FuncionariosModel findById(Long id) {
		return funcionariosRepository.findById(id).get();
	}

	@Override
	public FuncionariosModel save(FuncionariosModel obj) {
		return funcionariosRepository.save(obj);
	}

	@Override
	public List<FuncionariosModel> findAll() {
		return funcionariosRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		funcionariosRepository.deleteById(id);

	}
	
	public FuncionariosModel verifyEmail(String email) {
		return funcionariosRepository.verifyEmail(email);
	}

}
