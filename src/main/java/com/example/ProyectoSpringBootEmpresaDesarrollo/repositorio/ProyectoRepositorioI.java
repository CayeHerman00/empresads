package com.example.ProyectoSpringBootEmpresaDesarrollo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;

public interface ProyectoRepositorioI extends JpaRepository<Proyectos, Long> {

	@Query(value = "SELECT * FROM dam_proyectos WHERE id = ?", nativeQuery = true)
	Proyectos findProyectoByID(long idProyecto);
	
	@Query(value = "SELECT e.* FROM dam_proyectos e, proyectos_empleados u WHERE e.id = u.proyectos_id and u.empleados_id = ?1", nativeQuery = true)
	List<Proyectos> findByEmpleado(Long id);
	
}
