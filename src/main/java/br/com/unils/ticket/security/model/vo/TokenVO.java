package br.com.unils.ticket.security.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TokenVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private Boolean authenticated;
	private Date created;
	private Date expiration;
	private String accessToken;
	private String refreshToken;
	private String nomeFuncionario;
	private Long codFuncionario;

	public TokenVO(String username, Boolean authenticated, Date created, Date expiration, String accessToken,
			String refreshToken, String nomeFuncionario, Long codFuncionario) {
		this.username = username;
		this.authenticated = authenticated;
		this.created = created;
		this.expiration = expiration;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.nomeFuncionario = nomeFuncionario;
		this.codFuncionario = codFuncionario;
	}

	public TokenVO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public Long getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(Long codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessToken, authenticated, created, expiration, refreshToken, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenVO other = (TokenVO) obj;
		return Objects.equals(accessToken, other.accessToken) && Objects.equals(authenticated, other.authenticated)
				&& Objects.equals(created, other.created) && Objects.equals(expiration, other.expiration)
				&& Objects.equals(refreshToken, other.refreshToken) && Objects.equals(username, other.username);
	}

}
