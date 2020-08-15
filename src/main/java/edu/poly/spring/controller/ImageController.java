package edu.poly.spring.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.spring.models.Staffs;
import edu.poly.spring.services.StaffService;



@Controller
public class ImageController {
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value = "getimage/{id}", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> dowloadLinkImage(@PathVariable Integer id){
		Optional<Staffs> sop = staffService.findById(id);
		
		if (sop.isPresent()) {
			Staffs staff = sop.get();
			try {
				Path filename = Paths.get("images", staff.getAnh());
				byte[] buffer = Files.readAllBytes(filename);
				
				ByteArrayResource bsr = new ByteArrayResource(buffer);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/png"))
						.body(bsr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.badRequest().build();
	}
}
