package com.diogo.gastos.view.bean;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diogo.gastos.dto.GastosDTO;
import com.diogo.gastos.view.impl.GastosServiceView;

@Component
@ViewScoped
public class GastosBean  implements Serializable{

	private static final long serialVersionUID = 3123400674621187115L;

	private static final String COMPONENTE_lISTA = "form:listaGastos";
	private static final String COMPONTE_PAINEL_CADASTRO = "form:painelCadastro";
	
	@Autowired
	public GastosServiceView gastoServiceView;
	
	private DataModel<GastosDTO> listaGastos;
	private GastosDTO gastosDTO;
	private Boolean editandoRegistro;
	private Long idBusca;
	
	@PostConstruct
	public void init() {
		this.gastosDTO = new GastosDTO();
	}
	
	public void retornarGastos() {
		this.gastosDTO = new GastosDTO();
		this.listaGastos = new ListDataModel<GastosDTO>(this.gastoServiceView.retornarGastos());
		atualizarLista();
	}
	
	public void cancelar() {
		this.gastosDTO = new GastosDTO();
	}

	private void atualizarLista() {
		PrimeFaces.current().ajax().update(COMPONENTE_lISTA);
	}
	
	public void buscar() {
		if (Objects.nonNull(this.idBusca) && this.idBusca > 0) {
			this.listaGastos = new ListDataModel<GastosDTO>(this.gastoServiceView.retornarGastosId(this.idBusca)); 
		} else {
			this.listaGastos = new ListDataModel<GastosDTO>(this.gastoServiceView.retornarGastos()); 
		}
		atualizarLista();
	}
	
	public void inserirRegistro() {
		this.gastoServiceView.inserirGastos(this.gastosDTO);
		atualizarInformacoes();
	}	
	public void editarRegistro() {
		this.gastosDTO = this.listaGastos.getRowData();
	}

	public void excluirRegistro() {
		this.gastoServiceView.DeletarGasto(this.listaGastos.getRowData());
		atualizarInformacoes();
	}

	private void atualizarInformacoes() {
		this.listaGastos = new ListDataModel<GastosDTO>(this.gastoServiceView.retornarGastos());
		cancelar();
		atualizarLista();		
		atualizarPainel();
	}
	
	private void atualizarPainel() {
		PrimeFaces.current().ajax().update(COMPONTE_PAINEL_CADASTRO);
	}
	
	public DataModel<GastosDTO> getListaGastos() {
		return listaGastos;
	}

	public void setListaGastos(DataModel<GastosDTO> listaGastos) {
		this.listaGastos = listaGastos;
	}

	public GastosDTO getGastosDTO() {
		return gastosDTO;
	}

	public void setGastosDTO(GastosDTO gastosDTO) {
		this.gastosDTO = gastosDTO;
	}

	public Boolean getEditandoRegistro() {
		return editandoRegistro;
	}

	public void setEditandoRegistro(Boolean editandoRegistro) {
		this.editandoRegistro = editandoRegistro;
	}

	public Long getIdBusca() {
		return idBusca;
	}

	public void setIdBusca(Long idBusca) {
		this.idBusca = idBusca;
	}
}
