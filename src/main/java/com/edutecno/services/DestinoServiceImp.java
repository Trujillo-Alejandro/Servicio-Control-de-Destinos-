package com.edutecno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.model.Destino;
import com.edutecno.repository.DestinoRepository;


@Service
public class DestinoServiceImp implements DestinoService {
	// Inyeccion de dependencias
	@Autowired				// Aqui es como se conectan con el CRUD que provee JPA
	private DestinoRepository destinoRepository;  // public interface DestinoRepository extends JpaRepository<Destino, Long> 
	
	@Override
	@Transactional( readOnly = true)
	public List<Destino> findAll() { // ---------------------------------------
		return destinoRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Destino destino) { //------------------------------------------
		destinoRepository.save(destino);

	}

	@Override
	@Transactional
	public void update(Destino destino) { //---------------------------------------------
		destinoRepository.save(destino);

	}

	@Override
	@Transactional
	public void delete(Destino destino) { //-----------------------------------------------
		destinoRepository.delete(destino);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Destino> findById(Long id) {  // -------------------------------------------
		return destinoRepository.findById(id);
	}

}
