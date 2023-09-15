package me.joaof.regescweb.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import me.joaof.regescweb.dto.RequisicaoNovoProfessor;
import me.joaof.regescweb.models.Professor;
import me.joaof.regescweb.models.StatusProfessor;
import me.joaof.regescweb.repositories.ProfessorRepository;

@Controller
public class ProfessorController {
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	@GetMapping("/professores")
	public ModelAndView index() {
		List<Professor> professores = professorRepository.findAll();
		
		ModelAndView mv = new ModelAndView("professores/index"); 
		mv.addObject("professores", professores);
		return mv;
	}
	
	@GetMapping("/professores/new")
	public ModelAndView novoProfessor() {
		ModelAndView mv = new ModelAndView("professores/new");
		mv.addObject("statusProfessor", StatusProfessor.values());
		return mv;
	}
	
	@PostMapping("/professores")
	public String create(RequisicaoNovoProfessor requisicaoNovoProfessor) {
		professorRepository.save(requisicaoNovoProfessor.toProfessor());
		return "redirect:/professores";
	}
	
}
