package br.com.unils.ticket.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionarios")
public class FuncionariosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codFuncionario;
	private String nome;
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_setor")
	private SetorModel setor;

	@OneToMany(mappedBy = "funcionarios")
	private List<TicketModel> tickets;

	public FuncionariosModel() {
	}

	public Long getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(Long codFuncionario) {
		this.codFuncionario = codFuncionario;
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
		return Objects.hash(codFuncionario, email, nome, setor, tickets);
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
				&& Objects.equals(nome, other.nome) && Objects.equals(setor, other.setor)
				&& Objects.equals(tickets, other.tickets);
	}

	@Override
	public String toString() {
		return "FuncionariosModel [codFuncionario=" + codFuncionario + ", nome=" + nome + ", email=" + email + "]";
	}

}
