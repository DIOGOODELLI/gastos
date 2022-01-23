package com.diogo.gastos.dto;

import java.io.Serializable;
import java.util.Date;

public class GastosDTO implements Serializable{

	private static final long serialVersionUID = 6399134561444879669L;
	
	private long id;
	private String nomePessoa;
	private String descricao;
	private Date dataHora;
	private Double valor;
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
