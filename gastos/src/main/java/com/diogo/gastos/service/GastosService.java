package com.diogo.gastos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diogo.gastos.dto.GastosDTO;

@Service
public interface GastosService {
	
	public GastosDTO salvar (GastosDTO gastoDTO);
	
	public GastosDTO deletar (GastosDTO gastoDTO);
	
	public List<GastosDTO> retornarGastos();
	
	public List<GastosDTO> retornarGastosId(Long id);
}
