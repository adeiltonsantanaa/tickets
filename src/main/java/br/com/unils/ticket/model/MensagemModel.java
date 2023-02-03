package br.com.unils.ticket.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mensagem")
public class MensagemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMensagem;

	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_ticket")
	private TicketModel ticket;

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
		return Objects.hash(codMensagem, descricao);
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
		return Objects.equals(codMensagem, other.codMensagem) && Objects.equals(descricao, other.descricao);
	}

	@Override
	public String toString() {
		return "MensagemModel [codMensagem=" + codMensagem + ", descricao=" + descricao + "]";
	}

}
