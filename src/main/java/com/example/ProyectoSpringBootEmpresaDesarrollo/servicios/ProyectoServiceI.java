package com.example.ProyectoSpringBootEmpresaDesarrollo.servicios;

import java.util.List;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;


public interface ProyectoServiceI {
	
	public List<Proyectos> obtenerTodosProyectos();

	//public List<Proyectos> obtenerProyectosPorEmpleado(final Long IdEmpleado);

	public void eliminarProyectoPorId(final long Id);

	public void aniadirProyecto(final Proyectos proyecto);

	public void actualizarProyecto(final Proyectos proyecto);
	
	
}
