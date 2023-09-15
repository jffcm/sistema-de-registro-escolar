package me.joaof.regescweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.joaof.regescweb.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
