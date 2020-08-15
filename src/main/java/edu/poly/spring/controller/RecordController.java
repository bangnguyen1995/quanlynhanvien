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

import edu.poly.spring.models.Records;
import edu.poly.spring.models.Staffs;
import edu.poly.spring.models.departs;
import edu.poly.spring.services.RecordService;
import edu.poly.spring.services.StaffService;

@Controller
@RequestMapping("/record")
public class RecordController {
	@Autowired
	RecordService recordService;
	@Autowired 
	StaffService staffService;

	@GetMapping("/find/{id}")
	public String find(ModelMap model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("staffID", id);

		List<Records> list = recordService.findByStaffId(id);
		Optional<Staffs> staff = staffService.findById(id);
		
		Records record = new Records();
		record.setStaff(staff.get());
		
		model.addAttribute("records", list);
		model.addAttribute("record", record);
		return "Record/list";
	}
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Integer id) {
	
	
	recordService.deleteById(id);
	return "Record/delete";
	
	}
	

	@PostMapping("/saveOredit")
	public String saveOrupdate(Records record) {
		recordService.save(record);

		return "redirect:find/" + record.getStaff().getId();
	}
}
