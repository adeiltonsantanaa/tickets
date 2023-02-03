package br.com.unils.ticket.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_problemas")
public class ProblemasModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProblema;

	private String nome;
	private String descricao;

	@OneToMany(mappedBy = "problemas")
	private List<TicketModel> tickets;

	public ProblemasModel() {
	}

	public Long getCodProblema() {
		return codProblema;
	}

	public void setCodProblema(Long codProblema) {
		this.codProblema = codProblema;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<TicketModel> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketModel> tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codProblema, descricao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProblemasModel other = (ProblemasModel) obj;
		return Objects.equals(codProblema, other.codProblema) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "ProblemasModel [codProblema=" + codProblema + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}
