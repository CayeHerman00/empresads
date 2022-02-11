package com.example.ProyectoSpringBootEmpresaDesarrollo.servicios;

import java.util.List;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;

public interface EmpleadoServiceI {

	public List<Empleados> obtenerTodosEmpleados();

	public List<Empleados> obtenerEmpleadosPorProyecto(final Long Id);

	public void eliminarEmpleadoPorId(final long Id);

	public void aniadirEmpleado(final Empleados empleado);

	public void actualizarEmpleado(final Empleados empleado);
	
}
