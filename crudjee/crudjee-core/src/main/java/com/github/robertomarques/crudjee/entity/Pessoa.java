package com.github.robertomarques.crudjee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pessoa",nullable=false)
	@Id	
	private Long id;
	
	@Column(name="nome_pessoa",nullable=false)
	private String nome;

	public Pessoa(Long id, String nome) {
		this.id = id;		
		this.nome = nome;
	}
	
	public Pessoa() {		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
