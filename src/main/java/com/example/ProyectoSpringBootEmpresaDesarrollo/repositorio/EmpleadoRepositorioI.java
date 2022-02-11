package com.example.ProyectoSpringBootEmpresaDesarrollo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Empleados;

@Repository
public interface EmpleadoRepositorioI extends JpaRepository<Empleados, Long> {
	
	
}
