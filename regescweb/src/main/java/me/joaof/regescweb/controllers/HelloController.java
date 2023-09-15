package me.joaof.regescweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

	@GetMapping("/exemplo")
	public String hello(Model model) {
		model.addAttribute("nome", "João");
		return "hello";
	}
	
	@GetMapping("/exemplo2")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("nome", "Luan");
		return mv;
	}
	
	@GetMapping("/exemplo3")
	public String hello(HttpServletRequest req) {
		req.setAttribute("nome", "Astolfo");
		return "hello";
	}
}
