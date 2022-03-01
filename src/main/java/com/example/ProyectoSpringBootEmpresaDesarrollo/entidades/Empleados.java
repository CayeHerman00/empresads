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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dam_empleados")
@Data @AllArgsConstructor @NoArgsConstructor
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
	
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Proyectos_Empleados",
            joinColumns = @JoinColumn(name = "Proyectos_id"),
            inverseJoinColumns = @JoinColumn(name = "empleados_id")
    )
    public List<Proyectos> Proyectos = new ArrayList<>();


	public Empleados(@NotNull(message = "No puede estar vacio") @Size(max = 20) String nombre,
			@NotNull(message = "No puede estar vacio") @Size(max = 40) String apellidos,
			@NotNull(message = "No puede estar vacio") Date fecha_nac,
			@NotNull(message = "No puede estar vacio") @Size(max = 9) String dNI,
			List<com.example.ProyectoSpringBootEmpresaDesarrollo.entidades.Proyectos> proyectos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nac = fecha_nac;
		DNI = dNI;
		Proyectos = proyectos;
	}
	
	
	
	
	
}
