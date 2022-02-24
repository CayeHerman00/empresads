package com.example.ProyectoSpringBootEmpresaDesarrollo.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;
import com.example.ProyectoSpringBootEmpresaDesarrollo.servicios.ProyectoServiceI;

@Controller
public class ProyectosController {

	@Autowired
	private ProyectoServiceI service;
	
	@GetMapping("/showProjectsView")
	public String mostrarProyectos(Model model) {

		// Obtención de vehículos
		final List<Proyectos> listaCoches = service.obtenerTodosProyectos();

		// Carga de datos al modelo
		model.addAttribute("carsListView", listaCoches);
		model.addAttribute("btnDropCarEnabled", Boolean.FALSE);

		return "ShowProjects";
	}

	/*@PostMapping("/actDropCar")
	public String eliminarCoche(@RequestParam String carId, Model model) {

		// Eliminación de vehículo
		cocheServiceI.eliminarCochePorId(Long.valueOf(carId));

		return "redirect:showCarsView";

	}
*/
	/*@PostMapping("/actSearchCar")
	public String submitBuscarCocheForm(@ModelAttribute Coche searchedCar, Model model) throws Exception {

		List<Coche> listaCoches = new ArrayList<Coche>();
		
		System.out.println(searchedCar.getMarca());

		final String cocheMatricula = searchedCar.getMatricula();
		final String cocheMarca = searchedCar.getMarca();
		final String cocheModelo = searchedCar.getModelo();

		System.out.println(cocheMatricula);
		if (StringUtils.hasText(cocheMatricula)) {

			// Búsqueda por matrícula
			final Coche coche = cocheServiceI.obtenerCochePorMatricula(cocheMatricula);

			if (coche != null) {
				listaCoches.add(coche);
			}
		} else if (!StringUtils.hasText(cocheMatricula)
				&& (StringUtils.hasText(cocheMarca) || StringUtils.hasText(cocheModelo))) {

			// Búsqueda por marca o modelo
			listaCoches = cocheServiceI.obtenerCochePorMarcaOModelo(cocheMarca, cocheModelo);

		} else if (!StringUtils.hasText(cocheMatricula)
				&& (StringUtils.hasText(cocheMarca) && StringUtils.hasText(cocheModelo))) {

			listaCoches = cocheServiceI.obtenerCochePorMarcaYModelo(cocheMarca, cocheModelo);

		} else {
			throw new Exception("Parámetros de búsquieda erróneos.");
		}

		// Carga de datos al modelo
		model.addAttribute("carsListView", listaCoches);
		model.addAttribute("btnDropCarEnabled", Boolean.TRUE);

		return "showCars";

	}

	@PostMapping("/actAddCar")
	private String aniadirCoche(@Valid @ModelAttribute Coche newCar, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			cocheServiceI.aniadirCoche(newCar);
		}

		return "redirect:showCarsView";
	}*/

	
}
