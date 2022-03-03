package com.example.ProyectoSpringBootEmpresaDesarrollo.servicios;

import java.util.List;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;

public interface EmpleadoServiceI {

	public List<Empleados> obtenerTodosEmpleados();

	public List<Empleados> obtenerEmpleadosPorProyecto(final Long Id);

	public void eliminarEmpleadoPorId(final long Id);

	public void aniadirEmpleado(final Empleados empleado);
	
	public Empleados obtenerEmpleadoPorId(final long Id);

	public void actualizarEmpleado(final Empleados empleado);
	
	public void insertarProyectoEmpleado(final long id_proyectos, final long id_empleados);
	
}
