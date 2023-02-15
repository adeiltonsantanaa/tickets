package br.com.unils.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.unils.ticket.service.ImagemService;

@RestController
@RequestMapping(value = "/api/imagem")
public class ImagemController {

	@Autowired
	private ImagemService imagemService;

	@PostMapping("/salvarImagem")
	public ResponseEntity<String> salvarImagem(@RequestParam("imagem") MultipartFile imagem) {
		System.out.println("chegou");
		return imagemService.salvarImagem(imagem);
	}

}
