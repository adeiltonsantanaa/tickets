package br.com.unils.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.interfacesOrAbstracts.Crud;
import br.com.unils.ticket.model.ProblemasModel;
import br.com.unils.ticket.repository.ProblemasRepository;

@Service
public class ProblemasService implements Crud<ProblemasModel> {

	@Autowired
	private ProblemasRepository problemasRepository;

	@Override
	public ProblemasModel findById(Long id) {
		return problemasRepository.findById(id).get();
	}

	@Override
	public ProblemasModel save(ProblemasModel obj) {
		return problemasRepository.save(obj);
	}

	@Override
	public List<ProblemasModel> findAll() {
		return problemasRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		problemasRepository.deleteById(id);
	}
}
