package com.manutcontrol.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
	@SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
	private Integer id;

	@Column(name = "email", nullable = false)
	@NotNull(message = "O e-mail é obrigatório")
	@Email(message = "O e-mail deve ser válido")
	private String email;

	@Column(name = "password", nullable = false)
	@NotNull(message = "A senha é obrigatória.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{8,}$", message = "A senha deve conter pelo menos 8 caracteres, uma letra, um número e um caractere especial.")
	private String password;

}
