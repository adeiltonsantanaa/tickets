package br.com.unils.ticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.model.SetorModel;
import br.com.unils.ticket.repository.SetorRepository;
import br.com.unils.ticket.service.SetorService;

@Service
public class SetorServiceImpl implements SetorService {

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
