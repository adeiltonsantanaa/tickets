package br.com.unils.ticket.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.unils.ticket.security.model.UserModel;

@Entity
@Table(name = "tb_funcionarios")
public class FuncionariosModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codFuncionario;
	private String nome;
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_setor")
	private SetorModel setor;

	@JsonBackReference
	@OneToMany(mappedBy = "funcionarios")
	private List<TicketModel> tickets;

	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<MensagemModel> mensagens;

	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<UserModel> user;

	public FuncionariosModel() {
	}

	public FuncionariosModel(Long codFuncionario, String nome, String email, SetorModel setor) {
		this.codFuncionario = codFuncionario;
		this.nome = nome;
		this.email = email;
		this.setor = setor;
	}

	public Long getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(Long codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public List<MensagemModel> getMensagens() {
		return mensagens;
	}

	public List<UserModel> getUser() {
		return user;
	}

	public void setUser(List<UserModel> user) {
		this.user = user;
	}

	public void setMensagens(List<MensagemModel> mensagens) {
		this.mensagens = mensagens;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SetorModel getSetor() {
		return setor;
	}

	public void setSetor(SetorModel setor) {
		this.setor = setor;
	}

	public List<TicketModel> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketModel> tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codFuncionario, email, mensagens, nome, setor, tickets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionariosModel other = (FuncionariosModel) obj;
		return Objects.equals(codFuncionario, other.codFuncionario) && Objects.equals(email, other.email)
				&& Objects.equals(mensagens, other.mensagens) && Objects.equals(nome, other.nome)
				&& Objects.equals(setor, other.setor) && Objects.equals(tickets, other.tickets);
	}

}
