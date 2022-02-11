package com.example.ProyectoSpringBootEmpresaDesarrollo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.servicios.EmpleadoServiceI;

@SpringBootApplication
public class ProyectoSpringBootEmpresaDesarrolloApplication /*implements CommandLineRunner*/{

	/*@Autowired
	private EmpleadoServiceI empService;*/
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringBootEmpresaDesarrolloApplication.class, args);
		
	}

	/*@Override
	public void run(String... args) throws Exception {
		List<Empleados> lista = empService.obtenerTodosEmpleados();
		for (Empleados emp : lista) {
			if (emp!=null) {
				System.out.println(emp);
			}
			
		}
		
	}*/

}
