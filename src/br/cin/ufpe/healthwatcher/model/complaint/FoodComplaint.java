package br.cin.ufpe.healthwatcher.model.complaint;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import br.cin.ufpe.healthwatcher.model.address.Address;

public class FoodComplaint extends Complaint implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer qtdeComensais;
	private Integer qtdeDoentes;
	private Integer qtdeInternacoes;
	private Integer qtdeObitos;
	
	@NotNull
	@Column(length = 100)
	private String localAtendimento;
	
	@NotNull
	@Column(length = 100)
	private String refeicaoSuspeita;
	
	private Address enderecoDoente;

	@Column(name="nome_vitima")
	private String nomeVitima;

	public FoodComplaint() {
		super();
	}   
	public Integer getQtdeComensais() {
		return this.qtdeComensais;
	}

	public void setQtdeComensais(Integer qtdeComensais) {
		this.qtdeComensais = qtdeComensais;
	}   
	public Integer getQtdeDoentes() {
		return this.qtdeDoentes;
	}

	public void setQtdeDoentes(Integer qtdeDoentes) {
		this.qtdeDoentes = qtdeDoentes;
	}   
	public Integer getQtdeInternacoes() {
		return this.qtdeInternacoes;
	}

	public void setQtdeInternacoes(Integer qtdeInternacoes) {
		this.qtdeInternacoes = qtdeInternacoes;
	}   
	public Integer getQtdeObitos() {
		return this.qtdeObitos;
	}

	public void setQtdeObitos(Integer qtdeObitos) {
		this.qtdeObitos = qtdeObitos;
	}   
	public String getLocalAtendimento() {
		return this.localAtendimento;
	}

	public void setLocalAtendimento(String localAtendimento) {
		this.localAtendimento = localAtendimento;
	}   
	public String getRefeicaoSuspeita() {
		return this.refeicaoSuspeita;
	}

	public void setRefeicaoSuspeita(String refeicaoSuspeita) {
		this.refeicaoSuspeita = refeicaoSuspeita;
	}   
	public Address getEnderecoDoente() {
		return this.enderecoDoente;
	}

	public void setEnderecoDoente(Address enderecoDoente) {
		this.enderecoDoente = enderecoDoente;
	}
	public String getNomeVitima() {
		return nomeVitima;
	}
	public void setNomeVitima(String nomeVitima) {
		this.nomeVitima = nomeVitima;
	}
   
}
