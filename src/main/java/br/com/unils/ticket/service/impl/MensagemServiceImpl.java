package br.com.unils.ticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.model.MensagemModel;
import br.com.unils.ticket.repository.MensagemRepository;
import br.com.unils.ticket.service.MensagemService;

@Service
public class MensagemServiceImpl implements MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;

	@Override
	public MensagemModel findById(Long id) {
		return mensagemRepository.findById(id).get();
	}

	@Override
	public MensagemModel save(MensagemModel obj) {
		return mensagemRepository.save(obj);
	}

	@Override
	public List<MensagemModel> findAll() {
		return mensagemRepository.findAll();
	}

	@Override
	public void remove(Long id) {
		mensagemRepository.deleteById(id);

	}
}
