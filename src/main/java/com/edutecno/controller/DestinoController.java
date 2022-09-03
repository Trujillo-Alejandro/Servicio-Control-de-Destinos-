package com.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.model.Destino;
import com.edutecno.services.DestinoService;
import com.edutecno.services.PasajeroService;

@Controller
@RequestMapping("destinos") // Mapping de entrada al controlador, path o ruta
public class DestinoController {
	// inyeccion de dependencias
	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private PasajeroService pasajeroService;
	
	@GetMapping  // Ruta Principal o root para la aplicacion, pero ahora sin "/", para que vuelva a cargar
	public ModelAndView destinos() { //---------------------------------------------------------------------------------------
		ModelAndView modelAndView = new ModelAndView("destinos"); // Se asigna a la vista mediante el constructor.esta va a aser la página principal
		modelAndView.addObject("destinos", destinoService.findAll()); //se agregan los datos al modelo y despacharlos a la vista
		return modelAndView;											// a la vista "destinos"
	}
	
	//metodo encargado de desplegar la vista de creacion del destino
	@GetMapping("/crear")
	public ModelAndView crear() { // --------------------------------------------------------------------------------------------
		
		ModelAndView modelAndView = new ModelAndView("crear-destino");
		modelAndView.addObject("destino", new Destino());
		modelAndView.addObject("pasajeros", pasajeroService.findAll());
		return modelAndView;
	}
	
	//metodo encargado de guardar el destino recibido desde la vista
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute Destino destino) { //----------------------------------------------------------
		destinoService.save(destino);
		return new RedirectView("/destinos");
	}
	
	//metodo encargado de desplegar la vista para editar el destino
	@GetMapping("/editar")
	public ModelAndView editar (@RequestParam Long id) { //----------------------------REVISAR-------------------------
		
		ModelAndView modelAndView = new ModelAndView("seleccionar-destino");
		modelAndView.addObject("destino", new Destino());
		modelAndView.addObject("destinoVO", destinoService.findById(id).get()); // Aquí  no corre el opcional
		modelAndView.addObject("pasajeros", pasajeroService.findAll());
		return modelAndView;
	}
	
	//metodo encargado de guardar el destino que se quiere editar
	@PostMapping("/editar")
	public RedirectView editar(@ModelAttribute Destino destino) {//-----------------------------------------------
		destinoService.update(destino);
		return new RedirectView("/destinos");  // vista destinos
	}
	
	//metodo encargado de eliminar el destino seleccionado en la vista
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam Long id) { //---------------------------------------------------------

		if (destinoService.findById(id).isPresent()) {
			destinoService.delete(destinoService.findById(id).get());
		}
		return new RedirectView("/destinos");
	}
	
	
}
