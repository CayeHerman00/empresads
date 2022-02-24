package com.example.ProyectoSpringBootEmpresaDesarrollo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;
import com.example.ProyectoSpringBootEmpresaDesarrollo.repositorio.ProyectoRepositorioI;

@Service
public class ProyectoServiceImpl implements ProyectoServiceI{

	@Autowired
	private ProyectoRepositorioI proyectoRepositorio;
	
	@Override
	public List<Proyectos> obtenerTodosProyectos() {
		return proyectoRepositorio.findAll();
	}

	/*@Override
	public List<Proyectos> obtenerProyectosPorEmpleado(Long IdEmpleado) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public void eliminarProyectoPorId(long Id) {
		proyectoRepositorio.deleteById(Id);
		
	}

	@Override
	public void aniadirProyecto(Proyectos proyecto) {
		proyectoRepositorio.save(proyecto);
		
	}

	@Override
	public void actualizarProyecto(Proyectos proyecto) {
		proyectoRepositorio.save(proyecto);
		
	}

}
