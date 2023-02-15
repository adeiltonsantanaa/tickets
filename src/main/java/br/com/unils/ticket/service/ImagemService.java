package br.com.unils.ticket.service;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {

	public ResponseEntity<String> salvarImagem(MultipartFile imagem) {
		try {
			if (!"image/jpeg".equals(imagem.getContentType())) {
				return ResponseEntity.badRequest().body("Somente imagens no formato JPEG são permitidas");
			}
			if (imagem.getSize() > 9700) {
				return ResponseEntity.badRequest().body("Imagem muito grande");
			}
			File arquivo = new File("C:\\Users\\adeilton.filho\\Desktop\\UniLS - Ticket\\tickets\\public\\fotos\\" + imagem.getOriginalFilename());
			imagem.transferTo(arquivo);
			return ResponseEntity.ok("Imagem salva com sucesso");
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar imagem"); 
		}
	}
}
