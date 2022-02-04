package com.example.ProyectoSpringBootEmpresaDesarrollo.entidades;

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
import javax.persistence.JoinTable;
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
@Table(name = "dam_proyectos")
public class Proyectos {
	
	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/*Identificador del proyecto*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "No puede estar vacio")
	@Size(max=20)
	@Column(name = "Titulo", nullable = false)
	private String titulo;
	
	@NotNull(message = "No puede estar vacio")
	@Size(max=20)
	@Column(name = "Descripcion", nullable = false)
	private String descripcion;
	
	@NotNull(message = "No puede estar vacio")
	@Size(max=20)
	@Column(name = "Fecha_Inicio", nullable = false)
	private Date fecha_inicio;
	
	@NotNull(message = "No puede estar vacio")
	@Size(max=20)
	@Column(name = "Fecha_Fin", nullable = false)
	private Date fecha_fin;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Proyectos_Empleados",
            joinColumns = @JoinColumn(name = "Proyectos_id"),
            inverseJoinColumns = @JoinColumn(name = "empleados_id")
    )
    private List<Empleados> Empleados = new ArrayList<>();
	
	
}
