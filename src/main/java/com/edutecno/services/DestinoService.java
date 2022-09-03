package com.edutecno.services;

import java.util.List;
import java.util.Optional;

import com.edutecno.model.Destino;

public interface DestinoService {

	public List<Destino> findAll();
	public void save(Destino destino);
	public void update(Destino destino);
	public void delete(Destino destino);
	public Optional<Destino> findById(Long id);
}
