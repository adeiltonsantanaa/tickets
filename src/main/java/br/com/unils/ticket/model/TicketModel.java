package br.com.unils.ticket.model;

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

@Entity
@Table(name = "tb_ticket")
public class TicketModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTicket;

	private String assunto;
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "id_problema")
	private ProblemasModel problemas;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private FuncionariosModel funcionarios;

	@OneToMany(mappedBy = "ticket")
	private List<MensagemModel> mensagens;

	public TicketModel() {
	}

	public Long getCodTicket() {
		return codTicket;
	}

	public void setCodTicket(Long codTicket) {
		this.codTicket = codTicket;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public ProblemasModel getProblemas() {
		return problemas;
	}

	public void setProblemas(ProblemasModel problemas) {
		this.problemas = problemas;
	}

	public FuncionariosModel getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(FuncionariosModel funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<MensagemModel> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<MensagemModel> mensagens) {
		this.mensagens = mensagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assunto, ativo, codTicket);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketModel other = (TicketModel) obj;
		return Objects.equals(assunto, other.assunto) && Objects.equals(ativo, other.ativo)
				&& Objects.equals(codTicket, other.codTicket);
	}

	@Override
	public String toString() {
		return "TicketModel [codTicket=" + codTicket + ", assunto=" + assunto + ", ativo=" + ativo + "]";
	}

}
