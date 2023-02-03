package br.com.unils.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.interfacesOrAbstracts.Crud;
import br.com.unils.ticket.model.SetorModel;
import br.com.unils.ticket.repository.SetorRepository;

@Service
public class SetorService implements Crud<SetorModel> {

	@Autowired
	private SetorRepository setorRepository;

	@Override
	public SetorModel save(SetorModel setorModel) {
		return setorRepository.save(setorModel);
	}

	@Override
	public SetorModel findById(Long id) {
		return setorRepository.findById(id).get();
	}

	@Override
	public List<SetorModel> findAll() {
		return setorRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		setorRepository.deleteById(id);
	}
}
