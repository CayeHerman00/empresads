package com.example.ProyectoSpringBootEmpresaDesarrollo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos;

public interface ProyectoRepositorioI extends JpaRepository<Proyectos, Long> {

}
