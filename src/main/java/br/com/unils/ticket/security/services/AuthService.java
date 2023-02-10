package br.com.unils.ticket.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.security.Jwt.JwtTokenProvider;
import br.com.unils.ticket.security.model.UserModel;
import br.com.unils.ticket.security.model.vo.LoginCredentialsVO;
import br.com.unils.ticket.security.model.vo.TokenVO;
import br.com.unils.ticket.security.repositories.UserRepository;

@Service
public class AuthService {

	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<TokenVO> signin(LoginCredentialsVO login) {
		try {
			UserModel user = userRepository.findByUsername(login.getUsername());
			boolean senhaValida = passwordEncoder.matches(login.getPassword(), user.getPassword());

			TokenVO tokenResponse = new TokenVO();
			if (user != null && senhaValida) {
				tokenResponse = tokenProvider.createAccessToken(login.getUsername(), user.getRoles(),
						user.getFuncionario().getNome(), user.getFuncionario().getCodFuncionario());
			} else {
				throw new UsernameNotFoundException("Username: " + login.getUsername() + " not found!");
			}
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid username/password!");
		}
	}

	public ResponseEntity<TokenVO> refreshToken(String username, String refreshToken) {
		UserModel user = userRepository.findByUsername(username);
		TokenVO tokenResponse = new TokenVO();
		if (user != null) {
			tokenResponse = tokenProvider.refreshToken(refreshToken);
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found!");
		}
		return ResponseEntity.ok(tokenResponse);
	}

}
