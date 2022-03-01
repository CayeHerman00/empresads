package com.example.ProyectoSpringBootEmpresaDesarrollo.controlador;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;
import com.example.ProyectoSpringBootEmpresaDesarrollo.servicios.ProyectoServiceI;

@Controller
public class ProyectosController {
	
	private long idU = 0L;

	@Autowired
	private ProyectoServiceI service;
	
	@GetMapping("/showProjectsView")
	public String mostrarProyectos(Model model) {

		// Obtención de vehículos
		final List<Proyectos> listaProyectos = service.obtenerTodosProyectos();

		// Carga de datos al modelo
		model.addAttribute("proyectosListView", listaProyectos);
		model.addAttribute("btnDropCarEnabled", Boolean.FALSE);

		return "showProjects";
	}
	
	@PostMapping("/actDropProyecto")
	public String eliminarProyecto(@RequestParam String proyectoId, Model model) {

		// Eliminación de vehículo
		service.eliminarProyectoPorId(Long.valueOf(proyectoId));

		return "redirect:showProjectsView";

	}

	@PostMapping("/actProjectAdd")
	private String aniadirProyecto(@Valid @ModelAttribute Proyectos Project, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de id erróneos");
		} else {

			// Se añade el nuevo coche
			service.aniadirProyecto(Project);
		}

		return "redirect:showProjectsView";
	}
	
	//actUpdProyecto
	
	@GetMapping("/actUpdProyecto")
	public String recogerProyecto(String proyectoId, Model model) {
		
	  
		idU = Long.valueOf(proyectoId);
	  
	  Proyectos p = service.obtenerProyectoPorId(Long.valueOf(proyectoId));

	//Carga de datos al modelo
	  model.addAttribute("titulo", p.getTitulo());
	  model.addAttribute("descripcion", p.getDescripcion());
	  model.addAttribute("fecha_inicio", p.getFecha_inicio());
	  model.addAttribute("fecha_fin", p.getFecha_fin());
	  
				
		return "editProyecto";
	}

	@GetMapping("/actEditProject")
	public String editarFutbolista(@Valid @ModelAttribute Proyectos Proyecto, BindingResult result) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Proyectos f = new Proyectos();

		f.setTitulo(Proyecto.getTitulo());
		f.setDescripcion(Proyecto.getDescripcion());
		f.setFecha_inicio(Proyecto.getFecha_inicio());
		f.setFecha_fin(Proyecto.getFecha_fin());
		
		
		
		if (result.hasErrors()) {
			throw new Exception("Parámetros de id erróneos");
		}
		else {
			
			service.eliminarProyectoPorId(idU);
			service.actualizarProyecto(Proyecto);
			
		}
		

		return "redirect:showProjectsView";
	}
	
	@PostMapping("/actSearchProyectosEmp")
	public String submitBuscaProyectosPorEmpleado(@RequestParam long id, Model model) throws Exception {

		List<Proyectos> listaProyectos = service.obtenerProyectosPorEmpleado(id);

		model.addAttribute("proyectosListView", listaProyectos);
		model.addAttribute("btnDropCarEnabled", Boolean.FALSE);

		return "showProjects";

	}
}
