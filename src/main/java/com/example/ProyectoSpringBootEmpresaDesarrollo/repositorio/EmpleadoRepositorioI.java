package com.example.ProyectoSpringBootEmpresaDesarrollo.repositorio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;
import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;

@Repository
public interface EmpleadoRepositorioI extends JpaRepository<Empleados, Long> {
	
	@Query(value = "SELECT * FROM dam_empleados WHERE id = ?", nativeQuery = true)
	Empleados findEmpleadosByID(long idEmpleado);
	
	@Query(value = "SELECT e.* FROM dam_empleados e, proyectos_empleados u WHERE e.id = u.empleados_id and u.proyectos_id = ?1", nativeQuery = true)
	List<Empleados> findByProyecto(Long id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO proyectos_empleados (proyectos_id, empleados_id) VALUES (?1, ?2)", nativeQuery = true)
	void insProyecto(long id_proyectos, long id_empleados);
	
	
	
}
