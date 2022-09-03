package com.edutecno.services;

import java.util.List;
import java.util.Optional;

import com.edutecno.model.Pasajero;

public interface PasajeroService {
	
	public List<Pasajero> findAll();
	public void save(Pasajero pasajero);
	public void update(Pasajero pasajero);
	public void delete(Pasajero pasajero);
	public Optional<Pasajero> findById(Long id); 

}
