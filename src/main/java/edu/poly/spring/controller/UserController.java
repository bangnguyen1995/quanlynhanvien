package edu.poly.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spring.models.Users;
import edu.poly.spring.models.departs;
import edu.poly.spring.services.DepartService;
import edu.poly.spring.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService  userService;
	@Autowired
	private DepartService  departService;
	@GetMapping("/login")
	public String form() {
		return "Users/login";
	}
	
@PostMapping("/login")
public String login(ModelMap model, 
		@RequestParam("name") String name,
		@RequestParam("pass") String pass ) {
	 Optional <Users> optUser =	userService.findById(name);
	 if(optUser.isPresent()) {
		if(optUser.get().getPassword().equals(pass)) {
			List<departs> list = (List<departs>) departService.findAll();
			model.addAttribute("depart",list);
			return"departs/listDeparts";
		
		}
		else {
			model.addAttribute("mesages","Password failed");
			return "Users/login";
		}
	 }
	else {
		model.addAttribute("mesage","Username failed");
		return "Users/login";
	}

		
}
}
