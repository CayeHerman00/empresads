package com.example.ProyectoSpringBootEmpresaDesarrollo.entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProyectoEmpleado {

	private Long idEmpleado;
	private Long idProyecto;
	
	
	
}
