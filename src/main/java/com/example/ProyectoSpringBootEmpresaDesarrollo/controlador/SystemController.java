package com.example.ProyectoSpringBootEmpresaDesarrollo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {
	
	//Capta cualquier solicitud
		@GetMapping
		public String showIndex() {
			return "index";
		}
		
		//PROYECTOS
		
		//Redirecciona al controlador de gestión de proyectos
		@GetMapping("/ShowAllProjects")
		public String redirectToShowAllProjectController() {
			return "redirect:showProjectsView";
		}
		
		//Redirecciona a la plantilla de búsqueda
		@GetMapping("/searchProjectByView")
		public String redirectToProjectSearchByTemplate() {
			return "searchCarBy";
		}
		
		//Redirecciona a la plantilla de insercción
		@GetMapping("/newProjectView")
		public String redirectToNewProjectTemplate() {
			return "newProject";
		}
		
		
		//EMPLEADOS
		
		//Redirecciona al controlador de gestión de empleados
		@GetMapping("/ShowAllEmployees")
		public String redirectToShowAllEmployeesController() {
			return "redirect:showEmployeesView";
		}
		
		//Redirecciona a la plantilla de insercción
		@GetMapping("/newEmployeeView")
		public String redirectToNewEmployeeTemplate() {
			return "newEmployee";
		}
		
		@GetMapping("/ShowEmployeesProyectView")
		public String redirectToShowEmployeesProjectController() {
			return "showEmployeesByProject";
		}
		
		@GetMapping("/ShowProjectsEmployeeView")
		public String redirectToShowProjectEmployeesController() {
			return "showProjectsByEmployee";
		}
		
		@GetMapping("/newProjectEmployee")
		public String redirectToNewProjectEmployeesController() {
			return "newProjectEmployeeA";
		}
		
		
		
		
}
