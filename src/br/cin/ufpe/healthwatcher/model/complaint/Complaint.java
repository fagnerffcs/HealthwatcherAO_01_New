package br.cin.ufpe.healthwatcher.model.complaint;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import br.cin.ufpe.healthwatcher.model.address.Address;
import br.cin.ufpe.healthwatcher.model.employee.Employee;
import br.cin.ufpe.healthwatcher.model.enumTypes.Situacao;

@MappedSuperclass
public abstract class Complaint {
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	@NotNull
	@Column(length = 100)
	private String solicitante;

	@NotNull
	@Column(length = 200)
	private String descricao;

	@Column(length = 200)
	private String observacao;

	@NotNull
	@Column(length = 100)
	private String email;

	private Employee atendente;

	@Enumerated
	private Situacao situacao;

	private Date dataParecer;

	private Date dataQueixa;

	private Address enderecoSolicitante;

	private long timestamp; // TODO para tratamento de concorrencia (scbs)
	
	public Complaint() {
	}
	
	// TODO: Verificar o construtor
	public Complaint(String solicitante, String descricao, String observacao, String email,
			Employee atendente, Situacao situacao, Date dataParecer, Date dataQueixa,
			Address enderecoSolicitante, long timestamp) {

		//Numero fica vazio por enquanto - no Repositorio ele eh inicializado
		this.solicitante = solicitante;
		this.descricao = descricao;
		this.observacao = observacao;
		this.email = email;
		this.atendente = atendente;
		this.situacao = situacao;
		this.dataParecer = dataParecer;
		this.dataQueixa = dataQueixa;
		this.enderecoSolicitante = enderecoSolicitante;
		this.timestamp = timestamp;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Employee getAtendente() {
		return atendente;
	}

	public void setAtendente(Employee atendente) {
		this.atendente = atendente;
	}

	public Date getDataParecer() {
		return dataParecer;
	}

	public void setDataParecer(Date dataParecer) {
		this.dataParecer = dataParecer;
	}

	public Date getDataQueixa() {
		return dataQueixa;
	}

	public void setDataQueixa(Date dataQueixa) {
		this.dataQueixa = dataQueixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getEnderecoSolicitante() {
		return enderecoSolicitante;
	}

	public void setEnderecoSolicitante(Address enderecoSolicitante) {
		this.enderecoSolicitante = enderecoSolicitante;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	// TODO: entender onde esse metodo esta sendo utilizado
	public void incTimestamp() {
		this.timestamp = timestamp + 1;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complaint other = (Complaint) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}*/
	
}
