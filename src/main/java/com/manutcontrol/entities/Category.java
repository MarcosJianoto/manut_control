package com.manutcontrol.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
	@SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull(message = "A categoria precisa estar vinculada a um usuário!")
	private UsersEntity user;

	@Column(name = "name", nullable = false)
	@NotNull(message = "A categoria precisa ter um nome")
	private String name;

	public Category() {
	}

	public Category(Integer id, UsersEntity user, String name) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
