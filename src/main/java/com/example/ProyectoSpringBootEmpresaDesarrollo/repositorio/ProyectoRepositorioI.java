package com.example.ProyectoSpringBootEmpresaDesarrollo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;

public interface ProyectoRepositorioI extends JpaRepository<Proyectos, Long> {

	//List <Proyectos> findByEmpleado(Long IdEmpleado);
	
	
	
}
