package br.com.unils.ticket.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_mensagem")
public class MensagemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMensagem;

	private String descricao;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_ticket")
	private TicketModel ticket;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private FuncionariosModel funcionario;

	public MensagemModel() {
	}

	public Long getCodMensagem() {
		return codMensagem;
	}

	public void setCodMensagem(Long codMensagem) {
		this.codMensagem = codMensagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public FuncionariosModel getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionariosModel funcionario) {
		this.funcionario = funcionario;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TicketModel getTicket() {
		return ticket;
	}

	public void setTicket(TicketModel ticket) {
		this.ticket = ticket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codMensagem, descricao, funcionario, ticket);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensagemModel other = (MensagemModel) obj;
		return Objects.equals(codMensagem, other.codMensagem) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(funcionario, other.funcionario) && Objects.equals(ticket, other.ticket);
	}

	@Override
	public String toString() {
		return "MensagemModel [codMensagem=" + codMensagem + ", descricao=" + descricao + "]";
	}

}
