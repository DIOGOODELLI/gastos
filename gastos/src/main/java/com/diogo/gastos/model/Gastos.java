package com.diogo.gastos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_gastos")
public class Gastos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gasto_sequence")
	@SequenceGenerator(name = "gasto_sequence", sequenceName = "seq_gasto", allocationSize = 1)
	private long id;

	@Column(name = "nome_pessoa")
	private String nomePessoa;
	
	@Column
	private String descricao;
	
	@Column(name = "data_hora")
	private Date dataHora;
	
	@Column
	private Double valor;
	
	@Column
	private String tags;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
