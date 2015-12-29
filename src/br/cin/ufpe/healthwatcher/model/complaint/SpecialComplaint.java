package br.cin.ufpe.healthwatcher.model.complaint;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.cin.ufpe.healthwatcher.model.address.Address;

@Entity
public class SpecialComplaint extends Complaint {
	private static final long serialVersionUID = 1L;
	
	private Short idade;
	
	@Column(length = 100)
	private String instrucao;
	
	@Column(length = 100)
	private String ocupacao;
	
	private Address enderecoOcorrencia;


	public SpecialComplaint() {
		super();
	}   
	public Short getIdade() {
		return this.idade;
	}

	public void setIdade(Short idade) {
		this.idade = idade;
	}   
	public String getInstrucao() {
		return this.instrucao;
	}

	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}   
	public String getOcupacao() {
		return this.ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}   
	public Address getEnderecoOcorrencia() {
		return this.enderecoOcorrencia;
	}

	public void setEnderecoOcorrencia(Address enderecoOcorrencia) {
		this.enderecoOcorrencia = enderecoOcorrencia;
	}
   
}
