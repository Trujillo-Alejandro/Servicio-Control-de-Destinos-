package com.edutecno.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator (name = "SQ_PASAJERO",initialValue = 1,allocationSize = 1,sequenceName = "SQ_PASAJERO")
public class Pasajero {

	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_PASAJERO") // Oracle
	private Long id;
	@Column(nullable = false , unique = true)
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String ciudadNatal;
	
	//campo que llevara la relación 1:N @OneToMany
	@OneToMany(mappedBy = "pasajero", fetch = FetchType.LAZY, cascade = CascadeType.ALL  ) // lazy, no inmediantamente cunado hacemos la query
	private List<Destino> destino;

}
