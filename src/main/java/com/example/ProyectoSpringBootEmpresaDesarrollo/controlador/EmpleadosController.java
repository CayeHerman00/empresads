package com.example.ProyectoSpringBootEmpresaDesarrollo.controlador;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;
import com.example.ProyectoSpringBootEmpresaDesarrollo.servicios.EmpleadoServiceI;

@Controller
public class EmpleadosController {
	
	private long idU = 0L;
	
	@Autowired
	private EmpleadoServiceI service;
	
	@GetMapping("/showEmployeesView")
	public String mostrarEmpleados(Model model) {

		// Obtención de vehículos
		final List<Empleados> listaEmpleados = service.obtenerTodosEmpleados();
		
		// Carga de datos al modelo
		model.addAttribute("empleadosListView", listaEmpleados);
		model.addAttribute("btnDropEmpleadoEnabled", Boolean.FALSE);

		return "showEmployees";
	}
	
	@PostMapping("/actDropEmpleado")
	public String eliminarEmpleado(@RequestParam String empleadoId, Model model) {

		// Eliminación de vehículo
		service.eliminarEmpleadoPorId(Long.valueOf(empleadoId));

		return "redirect:showEmployeesView";

	}
	
	@PostMapping("/actEmployeeAdd")
	private String aniadirEmpleado(@Valid @ModelAttribute Empleados Employee, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de id erróneos");
		} else {

			// Se añade el nuevo coche
			service.aniadirEmpleado(Employee);
		}

		return "redirect:showEmployeesView";
	}
	
	@GetMapping("/actUpdEmpleado")
	public String recogerEmpleado(String empleadoId, Model model) {
		
	  
		idU = Long.valueOf(empleadoId);
	  
	 Empleados p = service.obtenerEmpleadoPorId(Long.valueOf(empleadoId));

	//Carga de datos al modelo
	  model.addAttribute("nombre", p.getNombre());
	  model.addAttribute("apellidos", p.getApellidos());
	  model.addAttribute("DNI", p.getDNI());
	  model.addAttribute("fecha_nac", p.getFecha_nac());
	  
				
		return "editEmpleado";
	}

	@GetMapping("/actEditEmployee")
	public String editarEmpleado(@Valid @ModelAttribute Empleados empleado, BindingResult result) throws Exception {

		Empleados f = new Empleados();

		f.setNombre(empleado.getNombre());
		f.setApellidos(empleado.getApellidos());
		f.setDNI(empleado.getDNI());
		f.setFecha_nac(empleado.getFecha_nac());
		
		if (result.hasErrors()) {
			throw new Exception("Parámetros de id erróneos");
		}
		else {
			
			service.eliminarEmpleadoPorId(idU);
			service.actualizarEmpleado(empleado);
			
		}
		

		return "redirect:showEmployeesView";
	}
	
	@PostMapping("/actSearchEmpleadosPro")
	public String submitBuscarEmpleadosPorProyecto(@RequestParam long id, Model model) throws Exception {

		List<Empleados> listaEmpleados = service.obtenerEmpleadosPorProyecto(id);

		model.addAttribute("empleadosListView", listaEmpleados);
		model.addAttribute("btnDropEmpleadoEnabled", Boolean.FALSE);

		return "showEmployees";

	}
	

}
