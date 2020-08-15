package edu.poly.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.spring.models.departs;
import edu.poly.spring.services.DepartService;


@Controller
@RequestMapping("/departs")
public class DepartController {
	@Autowired
	private DepartService departService;
@GetMapping("/add")
public String add(ModelMap model) {
	model.addAttribute("depart",new departs());
	return("departs/addOredit");
}
@PostMapping("/saveOrupdate")
public String saveOrupdate( ModelMap model, departs depart) {
	String message = "Thêm mới thành công !";
	if(depart.getId() != null && depart.getId() > 0) {
		message = "Update thành không !";
	}
	departService.save(depart);
	model.addAttribute("depart",depart);
	model.addAttribute("message",message);
	return "departs/addOredit";
}
@GetMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable (name= "id") Integer id) {
 Optional <departs> optDepart =	departService.findById(id);
 if(optDepart.isPresent()) {
	 model.addAttribute("depart",optDepart.get());
 }
 else {
	return list(model);
}
	return "departs/addOredit";
}
@GetMapping("/delete/{id}")
public String delete(ModelMap model ,@PathVariable (name= "id") Integer id) {
	departService.deleteById(id);
	return list(model);
}
@GetMapping("/list")
public String list(ModelMap model) {
	List<departs> list = (List<departs>) departService.findAll();
	model.addAttribute("depart",list);
	return"departs/listDeparts";
}

}
