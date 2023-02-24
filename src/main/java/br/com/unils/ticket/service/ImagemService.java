package br.com.unils.ticket.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImagemService {

	public ResponseEntity<String> salvarImagem(MultipartFile imagem);

}
