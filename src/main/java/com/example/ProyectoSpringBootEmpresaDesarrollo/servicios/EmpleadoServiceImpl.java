package com.example.ProyectoSpringBootEmpresaDesarrollo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.repositorio.EmpleadoRepositorioI;

@Service
public class EmpleadoServiceImpl implements EmpleadoServiceI{
	
	@Autowired
	private EmpleadoRepositorioI empleadoRepositorio;

	@Override
	public List<Empleados> obtenerTodosEmpleados() {
		return empleadoRepositorio.findAll();
	}

	/*@Override
	public List<Empleados> obtenerEmpleadosPorProyecto(Long IdProyecto) {
		return empleadoRepositorio.findByProyecto(IdProyecto);
	}*/

	@Override
	public void eliminarEmpleadoPorId(long Id) {
		empleadoRepositorio.deleteById(Id);
		
	}

	@Override
	public void aniadirEmpleado(Empleados empleado) {
		empleadoRepositorio.save(empleado);	
		
	}

	@Override
	public void actualizarEmpleado(Empleados empleado) {
		empleadoRepositorio.save(empleado);	
		
	}
}
