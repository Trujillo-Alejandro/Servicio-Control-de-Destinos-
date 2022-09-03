package com.edutecno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.model.Pasajero;
import com.edutecno.repository.PasajeroRepository;

@Service    //anotacion para configurar en Spring el servicio
public class PasajeroServiceImp implements PasajeroService {
	// Inyeccion de dependencias
	@Autowired
	private PasajeroRepository pasajeroRepository;
	
	@Override
	@Transactional(readOnly =  true)
	public List<Pasajero> findAll() {  //---------------------------------------------------
		return pasajeroRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Pasajero pasajero) {  // --------------------------------------------
		pasajeroRepository.save(pasajero);
	}

	@Override
	@Transactional
	public void update(Pasajero pasajero) { //------------------------------------------------
		pasajeroRepository.save(pasajero);
	}

	@Override
	@Transactional
	public void delete(Pasajero pasajero) { // ---------------------------------------
		pasajeroRepository.delete(pasajero);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pasajero> findById(Long id) { //--------------------------------------------
		 
		return pasajeroRepository.findById(id);
	}

}
