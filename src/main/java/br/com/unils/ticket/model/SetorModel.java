package br.com.unils.ticket.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_setor")
public class SetorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codSetor;

	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "setor")
	private List<FuncionariosModel> funcionarios;

	public SetorModel() {
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
