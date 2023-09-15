package me.joaof.regescweb.models;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private BigDecimal salario;
	
	@Enumerated(EnumType.STRING)
	private StatusProfessor statusProfessor;
	
	public Professor() {}
	
	public Professor(String nome, BigDecimal salario, StatusProfessor statusProfessor) {
		this.nome = nome;
		this.salario = salario;
		this.statusProfessor = statusProfessor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public StatusProfessor getStatusProfessor() {
		return statusProfessor;
	}

	public void setStatusProfessor(StatusProfessor statusProfessor) {
		this.statusProfessor = statusProfessor;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", salario=" + salario + ", statusProfessor="
				+ statusProfessor + "]";
	}

}
