package com.example.ProyectoSpringBootEmpresaDesarrollo.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dam_empleados")
public class Empleados implements Serializable {
	
	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/*Identificador del empleado*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "No puede estar vacio")
	@Size(max=20)
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@NotNull(message = "No puede estar vacio")
	@Size(max=40)
	@Column(name = "Apellidos", nullable = false)
	private String apellidos;
	
	@NotNull(message = "No puede estar vacio")
	@Column(name = "Fecha_Nac", nullable = false)
	//@Temporal(TemporalType.DATE)
	private Date fecha_nac;
	
	@NotNull(message = "No puede estar vacio")
	@Size(max=9)
	@Column(name = "DNI", nullable = false)
	private String DNI;
	
	
	@ManyToMany(mappedBy = "Empleados")
    public List<Proyectos> Proyectos = new ArrayList<>();
	
	
	
}
