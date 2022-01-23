package com.diogo.gastos.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.gastos.api.converter.GastosConverter;
import com.diogo.gastos.dao.GastosDaoPage;
import com.diogo.gastos.dto.GastosDTO;
import com.diogo.gastos.model.Gastos;
import com.diogo.gastos.service.GastosService;

@Service
public class GastosServiceImp implements GastosService {
	
	@Autowired
	GastosDaoPage gastosDaoPage;
	
	@Autowired
	private GastosConverter converter;
	
	@Override
	public GastosDTO salvar(GastosDTO gastosDTO) {		
		Gastos gastos = this.converter.convertGastoDTOtoGasto(gastosDTO);
		try {
			this.gastosDaoPage.save(gastos);
		} catch (Exception e) {}
		
		return gastosDTO;
	}

	@Override
	public GastosDTO deletar(GastosDTO gastosDTO) {
		Gastos gastos = this.converter.convertGastoDTOtoGasto(gastosDTO);
		this.gastosDaoPage.deleteById(gastos.getId());
		return gastosDTO;
	}

	@Override
	public List<GastosDTO> retornarGastos() {
		List<GastosDTO> listaGastos = this.converter.convertListGastoToListGastoDTO(this.gastosDaoPage.retornarGastos()) ;
		if (Objects.nonNull(listaGastos)) {
			return listaGastos;
		}
		return null;
	}

	@Override
	public List<GastosDTO> retornarGastosId(Long id) {
		List<GastosDTO> listaGastos = this.converter.convertListGastoToListGastoDTO(this.gastosDaoPage.retornarGastosId(id)) ;
		if (Objects.nonNull(listaGastos)) {
			return listaGastos;
		}
		return null;
	}
}
