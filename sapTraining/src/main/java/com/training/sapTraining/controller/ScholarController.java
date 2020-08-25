package com.training.sapTraining.controller;

import java.util.List;
import com.training.sapTraining.model.Scholar;
import com.training.sapTraining.service.ScholarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("sch/v1")
public class ScholarController {	
	
	private ScholarService sS;
	
	@Autowired
	public ScholarController(ScholarService sS) {
		this.sS=sS;
	}
	
	@GetMapping("allScholars")
	@ResponseBody
	public List<Scholar> getAllScholars() {
		return sS.getAllScholars();
		}
	
	@GetMapping("scholar")
	@ResponseBody
	public String getScholar(@RequestParam String id) {
		return sS.getScholar(id);
	}
	
	@PostMapping("addScholar")
	public String postAddScholar(@RequestBody Scholar sch) {
		return sS.postAddScholar(sch);
	}
	
	@PostMapping("updateScholar")
	public String postUpdateScholar(@RequestBody Scholar sch) {
		return sS.postUpdateScholar(sch);
	}
	
	@DeleteMapping("deleteScholar")
	public String deleteScholar(@RequestParam String id) {
		return sS.deleteScholar(id);
	}
}
