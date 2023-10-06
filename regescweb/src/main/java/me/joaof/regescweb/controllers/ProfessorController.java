package me.joaof.regescweb.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import me.joaof.regescweb.dto.ProfessorDto;
import me.joaof.regescweb.models.Professor;
import me.joaof.regescweb.models.StatusProfessor;
import me.joaof.regescweb.repositories.ProfessorRepository;


@Controller
@RequestMapping("/professores")
public class ProfessorController {
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	@GetMapping
	public ModelAndView index() {
		List<Professor> professores = professorRepository.findAll();
		
		ModelAndView mv = new ModelAndView("professores/index"); 
		mv.addObject("professores", professores);
		return mv;
	}
	
	@GetMapping("/new")
	public ModelAndView novoProfessor(ProfessorDto professorDto) {
		ModelAndView mv = new ModelAndView("professores/new");
		mv.addObject("statusProfessor", StatusProfessor.values());
		return mv;
	}
	
	@PostMapping
	public ModelAndView create(@Valid ProfessorDto professorDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.err.println("\nERRORS FOUND: " + bindingResult.getErrorCount());
			
			ModelAndView mv = new ModelAndView("professores/new");
			mv.addObject("statusProfessor", StatusProfessor.values());
			return mv;
		}
		
		professorRepository.save(professorDto.toProfessor());
		return new ModelAndView("redirect:/professores");
	}
		
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable long id) {
		Optional<Professor> optional = professorRepository.findById(id);
		
		if (optional.isPresent()) {
			Professor professor = optional.get();
			ModelAndView mv = new ModelAndView("professores/show");
			mv.addObject("professor", professor);
			return mv;
		} else {
			return new ModelAndView("redirect:/professores");
		}
	
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable long id, ProfessorDto professorDto) {
		Optional<Professor> optional = professorRepository.findById(id);
		
		if (optional.isPresent()) {
			Professor professor = optional.get();
			professorDto.fromProfessor(professor);
			
			ModelAndView mv = new ModelAndView("professores/edit");
			mv.addObject("statusProfessor", StatusProfessor.values());
			mv.addObject("id", professor.getId());
			return mv;
		} else {
			return new ModelAndView("redirect:/professores");
		}
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable long id, @Valid ProfessorDto professorDto, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("professores/edit");
			mv.addObject("statusProfessor", StatusProfessor.values());
			return mv;
		} else {
			Optional<Professor> optional = professorRepository.findById(id);
			
			if (optional.isPresent()) {
				Professor professor = optional.get();
				professorRepository.save(professorDto.toProfessor(professor));
				
				return new ModelAndView("redirect:/professores/" + professor.getId());
				
			} else {
				return new ModelAndView("redirect:/professores");
			}
		}
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable long id) {
		if (professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
			return "redirect:/professores";
		} else {
			return "redirect:/professores";
		}
	}

}
