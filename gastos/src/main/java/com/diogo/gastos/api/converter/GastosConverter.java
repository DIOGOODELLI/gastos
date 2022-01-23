package com.diogo.gastos.api.converter;

import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diogo.gastos.dto.GastosDTO;
import com.diogo.gastos.model.Gastos;
import com.diogo.gastos.model.ModelMapperConverter;

import java.util.stream.Collectors;

@Component
public class GastosConverter {
	
	@Autowired
	private ModelMapperConverter converter;

	public Gastos convertGastoDTOtoGasto(GastosDTO gastoDTO) {
		return new ModelMapper().map(gastoDTO, Gastos.class);
	}
	
	public GastosDTO convertGastoToGastosDTO(Gastos gasto) {
		return new ModelMapper().map(gasto, GastosDTO.class);
	}
	
	public List<GastosDTO> convertListGastoToListGastoDTO(List<Gastos> listaGastos) {
		List<GastosDTO> lista = listaGastos.stream().map(new Function<Gastos, GastosDTO>() {
			@Override
			public GastosDTO apply(Gastos gastos) {
				GastosDTO dto = GastosConverter.this.converter.converter(gastos, GastosDTO.class);
				return dto;
			}
		}).collect(Collectors.toList());
		return lista;
	}
	
	
	
	
}
