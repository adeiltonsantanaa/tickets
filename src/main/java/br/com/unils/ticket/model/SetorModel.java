package br.com.unils.ticket.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_setor")
public class SetorModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codSetor;

	private String nome;

	@JsonBackReference
	@OneToMany(mappedBy = "setor")
	private List<FuncionariosModel> funcionarios;

	public SetorModel() {
	}

	public SetorModel(Long codSetor, String nome, List<FuncionariosModel> funcionarios) {
		super();
		this.codSetor = codSetor;
		this.nome = nome;
		this.funcionarios = funcionarios;
	}

	public Long getCodSetor() {
		return codSetor;
	}

	public List<FuncionariosModel> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionariosModel> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void setCodSetor(Long codSetor) {
		this.codSetor = codSetor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codSetor, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetorModel other = (SetorModel) obj;
		return Objects.equals(codSetor, other.codSetor) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "SetorModel [codSetor=" + codSetor + ", nome=" + nome + "]";
	}

}
