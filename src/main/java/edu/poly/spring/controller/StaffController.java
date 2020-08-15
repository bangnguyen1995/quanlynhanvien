package edu.poly.spring.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.spring.dtos.StaffDto;
import edu.poly.spring.models.Staffs;
import edu.poly.spring.models.departs;
import edu.poly.spring.services.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private StaffService staffService;

	@GetMapping("/list")
	public String list(ModelMap model) {
		List<Staffs> list = (List<Staffs>) staffService.findAll();

		model.addAttribute("list", list);

		return ("Staffs/listStaffs");
	}

	@GetMapping("/add")
	public String add(ModelMap model) {
		StaffDto staff = new StaffDto();
		model.addAttribute("staffDto", staff);
		return "Staffs/addStaff";
	}

	@PostMapping("/save")
	public String save(ModelMap model, StaffDto staffDto) {
		String message = "Thêm mới thành công !";
		if (staffDto.getId() != null && staffDto.getId() > 0) {
			message = "Update thành không !";
		}
		Path path = Paths.get("images/");

		try (InputStream inputStream = staffDto.getImage().getInputStream()) {
			Files.copy(inputStream, path.resolve(staffDto.getImage().getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			String filename = staffDto.getImage().getOriginalFilename();
		} catch (Exception e) {
			model.addAttribute("message", "Lỗi lưu file !" + e.getMessage());
		}
		Staffs staff = new Staffs();
		staff.setId(staffDto.getId());
		staff.setHoten(staffDto.getHoten());
	
		staff.setBirthday(staffDto.getBirthday());
		staff.setEmail(staffDto.getEmail());
		staff.setAnh(staffDto.getImage().getOriginalFilename());	staff.setLuong(staffDto.getLuong());
		staff.setMota(staffDto.getMota());
		staff.setSdt(staffDto.getSdt());
		staff.setGioitinh(staffDto.isGioitinh());
		departs depart = new departs();
		depart.setId(staffDto.getDepartID());
		staff.setDepart(depart);
		staffService.save(staff);
		model.addAttribute("staffDto", staffDto);
		model.addAttribute("message", message);
		return "Staffs/addStaff";
	}

	@ModelAttribute(name = "departs")
	List<departs> getDepart() {
		return staffService.findAllDepart();
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Integer id) {
		staffService.deleteById(id);
		List<Staffs> list = (List<Staffs>) staffService.findAll();
		model.addAttribute("list", list);
		return "Staffs/listStaffs";
	}

	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") Integer id) {
		Optional<Staffs> optStaff = staffService.findById(id);
		if (optStaff.isPresent()) {
			Staffs staff = optStaff.get();
			StaffDto staffDto = new StaffDto();
			staffDto.setId(staff.getId());
			staffDto.setDepartID(staff.getDepart().getId());
			staffDto.setEmail(staff.getEmail());
			staffDto.setBirthday(staff.getBirthday());
			staffDto.setGioitinh(staff.isGioitinh());
			staffDto.setHoten(staff.getHoten());
			staffDto.setLuong(staff.getLuong());
			staffDto.setMota(staff.getMota());
			staffDto.setSdt(staff.getSdt());
			System.out.print("departID:" + staff.getDepart().getId());
			model.addAttribute("staffDto", staffDto);

		} else {
			return list(model);
		}
		return "Staffs/addStaff";
	}

	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String name) {
		List<Staffs> list = staffService.findByHotenLikeOrderByHoten("%" + name + "%");
		model.addAttribute("list", list);
		return "Staffs/listStaffs";
	}
}
