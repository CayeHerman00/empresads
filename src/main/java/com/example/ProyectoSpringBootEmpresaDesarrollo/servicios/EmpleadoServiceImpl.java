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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleados> obtenerEmpleadosPorProyecto(Long IdProyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEmpleadoPorId(long Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aniadirEmpleado(Empleados empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEmpleado(Empleados empleado) {
		// TODO Auto-generated method stub
		
	}
}
