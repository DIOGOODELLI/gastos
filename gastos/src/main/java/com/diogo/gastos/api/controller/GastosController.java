package com.diogo.gastos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diogo.gastos.dto.GastosDTO;
import com.diogo.gastos.service.GastosService;

@CrossOrigin
@RestController
public class GastosController {
	
	private static final String PARAM_ID = "id";
	private static final String URL_RETORNO_GASTOS = "api/gastos/retornarGastos";
	private static final String URL_RETORNO_GASTOS_ID = "api/gastos/retornarGastos-id";
	private static final String URL_INSERIR_GASTOS = "api/gastos/gravarGasto";
	private static final String URL_DELETAR_GASTOS = "api/gastos/deletarGasto";
	
	@Autowired
	private GastosService service; 
	
	public GastosController (GastosService service) {
		this.service = service;
	}
	
	@PutMapping(URL_INSERIR_GASTOS)
	public GastosDTO gravargasto(@RequestBody GastosDTO dto ) {
		return this.service.salvar(dto);
	}
	
	@DeleteMapping(URL_DELETAR_GASTOS)
	public GastosDTO deletarGasto(@RequestBody GastosDTO dto ) {		
		return this.service.deletar(dto);
	}
	
	@GetMapping(URL_RETORNO_GASTOS)
	public List<GastosDTO> retornarGastos(){		
		return this.service.retornarGastos();
	}
	
	@GetMapping(URL_RETORNO_GASTOS_ID)
	public List<GastosDTO> retornarGastosId(@RequestParam(PARAM_ID) Long id){		
		return this.service.retornarGastosId(id);
	}
}
