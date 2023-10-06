package me.joaof.regescweb.dto;
import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.joaof.regescweb.models.Professor;
import me.joaof.regescweb.models.StatusProfessor;

// DTO
public class ProfessorDto {
	@NotBlank(message="O nome do professor não deve estar em branco.")
	private String nome;
	
	@NotNull(message="O campo salário não deve estar nulo.")
	@DecimalMin(value="0.0", message="O campo salário deve ser um número maior ou igual a 0.0.")
	@DecimalMax(value="1000000", message="O campo salário deve ser um número menor ou igual a 1.000.000.")
	private BigDecimal salario;
	
	private StatusProfessor statusProfessor;
	
	public ProfessorDto() {}

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

	public Professor toProfessor() {
		Professor professor = new Professor();
		professor.setNome(this.nome);
		professor.setSalario(this.salario);
		professor.setStatusProfessor(this.statusProfessor);
		
		return professor;
	}
	
	public Professor toProfessor(Professor professor) {
		professor.setNome(this.nome);
		professor.setSalario(this.salario);
		professor.setStatusProfessor(this.statusProfessor);
		
		return professor;
	}
	
	public void fromProfessor(Professor professor) {
		this.nome = professor.getNome();
		this.salario = professor.getSalario();
		this.statusProfessor = professor.getStatusProfessor();
		
	}

	@Override
	public String toString() {
		return "ProfessorDto [nome=" + nome + ", salario=" + salario + ", statusProfessor=" + statusProfessor + "]";
	}
	
}
