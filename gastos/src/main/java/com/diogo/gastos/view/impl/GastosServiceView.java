package com.diogo.gastos.view.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.diogo.gastos.dto.GastosDTO;

@Service
public class GastosServiceView {
	
	private static final String PARAM_ID = "id";
	private static final String URL_RETORNO_GASTOS = "http://localhost:8080/api/gastos/retornarGastos";
	private static final String URL_RETORNO_GASTOS_ID = "http://localhost:8080/api/gastos/retornarGastos-id";
	private static final String URL_INSERIR_GASTOS = "http://localhost:8080/api/gastos/gravarGasto";
	private static final String URL_DELETAR_GASTOS = "http://localhost:8080/api/gastos/deletarGasto";
	
	public List<GastosDTO> retornarGastos(){
		RestTemplate restTemplate = new RestTemplate();		
		ParameterizedTypeReference<List<GastosDTO>> responseType = new ParameterizedTypeReference<List<GastosDTO>>() { };
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_RETORNO_GASTOS);
		ResponseEntity<List<GastosDTO>> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
		return result.getBody();
	}
	
	public List<GastosDTO> retornarGastosId(Long id){
		RestTemplate restTemplate = new RestTemplate();		
		ParameterizedTypeReference<List<GastosDTO>> responseType = new ParameterizedTypeReference<List<GastosDTO>>() { };
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_RETORNO_GASTOS_ID).queryParam(PARAM_ID, id);
		ResponseEntity<List<GastosDTO>> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
		return result.getBody();
	}
	
	public void inserirGastos(GastosDTO gastosDTO) {
		RestTemplate restTemplate = new RestTemplate();	
		HttpEntity<GastosDTO> request = new HttpEntity<GastosDTO>(gastosDTO);
		restTemplate.exchange(URL_INSERIR_GASTOS, HttpMethod.PUT, request, GastosDTO.class);
	}
	
	public void DeletarGasto(GastosDTO gastosDTO) {
		RestTemplate restTemplate = new RestTemplate();	
		HttpEntity<GastosDTO> request = new HttpEntity<GastosDTO>(gastosDTO);
		restTemplate.exchange(URL_DELETAR_GASTOS, HttpMethod.DELETE, request, GastosDTO.class);
	}
}
