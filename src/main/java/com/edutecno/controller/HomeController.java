package com.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edutecno.services.DestinoService;

@Controller
public class HomeController {
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping("/")  // Ruta Principal o root para la aplicacion
	public ModelAndView home() {  // -------------------------------------------------------------------------------------
		ModelAndView modelAndView = new ModelAndView("destinos"); // Se asigna a la vista mediante el constructor.esta va a aser la página principal
		modelAndView.addObject("destinos", destinoService.findAll()); //se agregan los datos al modelo y despacharlos a la vista
		return modelAndView;											// a la vista "destinos"
		
		// No se agraga RequestMapping, en caso de hacerlo se pone después del controller y  borra el GetMapping del método
		
	}

}
