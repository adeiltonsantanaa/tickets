package br.com.unils.ticket.security.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.unils.ticket.exceptions.InvalidEmailException;
import br.com.unils.ticket.model.FuncionariosModel;
import br.com.unils.ticket.security.Jwt.JwtTokenProvider;
import br.com.unils.ticket.security.model.PermissionModel;
import br.com.unils.ticket.security.model.UserModel;
import br.com.unils.ticket.security.model.vo.LoginCredentialsVO;
import br.com.unils.ticket.security.model.vo.TokenVO;
import br.com.unils.ticket.security.model.vo.UserVO;
import br.com.unils.ticket.security.model.vo.UserVOResponse;
import br.com.unils.ticket.security.repositories.UserRepository;
import br.com.unils.ticket.service.FuncionariosService;

@Service
public class AuthService {

	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FuncionariosService funcionariosService;

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

	public UserVOResponse createUser(UserVO obj) {
		FuncionariosModel funcionario = funcionariosService.verifyEmail(obj.getEmail());
		if (funcionario != null) {
			obj.setPassword(passwordEncoder.encode(obj.getPassword()));
			UserModel user = instanciaUser(obj, funcionario);
			userRepository.save(user);
			return new UserVOResponse(user.getUsername(), user.getFullName());
		}
		throw new InvalidEmailException("E-mail não cadastrado! Fale com o administrador.");
	}

	private UserModel instanciaUser(UserVO obj, FuncionariosModel funcionario) {
		UserModel user = new UserModel(obj.getUsername(), obj.getFullName(), obj.getPassword());
		return setParams(user, funcionario);
	}

	private UserModel setParams(UserModel user, FuncionariosModel funcionario) {
		user.setFuncionario(funcionario);
		List<PermissionModel> permission = Arrays.asList(new PermissionModel(2L, "FUN"));
		user.setPermissions(permission);
		return user;
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
