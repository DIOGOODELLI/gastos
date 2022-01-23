package com.diogo.gastos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.diogo.gastos.model.Gastos;

@RepositoryRestResource(collectionResourceRel = "gasto", path = "gastos")
public interface GastosDaoPage extends PagingAndSortingRepository<Gastos, Long>{
	
	@Query("SELECT u FROM Gastos u")
	public List<Gastos> retornarGastos();
	
	@Query("SELECT u FROM Gastos u WHERE u.id = :id")
	public List<Gastos> retornarGastosId(@Param("id") Long id);
}
