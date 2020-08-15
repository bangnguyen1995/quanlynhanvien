package edu.poly.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import edu.poly.spring.models.Vahicle;
import edu.poly.spring.services.VahicleService;






@Controller

public class VahicleController {
	@Autowired 
	private VahicleService vahicleService ;
	@GetMapping("/list")
	public String list(ModelMap model) {
		List<Vahicle> list = (List<Vahicle>) vahicleService.findAll();
		model.addAttribute("vahicle",list);
		return "list";
	}
	
   @GetMapping("/save")
public String save(ModelMap model) {
	model.addAttribute("vahicle",new Vahicle());
	return "save";
}
    @PostMapping("/saveOrupdate")
public String saveOrupdate( ModelMap model, Vahicle vahicle) {
	vahicleService.save(vahicle);
	return "save";}
}
