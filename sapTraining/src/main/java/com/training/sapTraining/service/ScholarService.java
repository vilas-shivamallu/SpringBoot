package com.training.sapTraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sapTraining.model.Scholar;
import com.training.sapTraining.repository.ScholarRepository;


@Service 
public class ScholarService {
	
	private ScholarRepository sR;
	@Autowired
	public ScholarService(ScholarRepository sR) {
		this.sR=sR;
	}
	
	public List<Scholar> getAllScholars() {	//Return All Scholar details
		return sR.getAllScholars();
		}
	
	public String getScholar(String id) { //Return scholar details based on ID
		return sR.getScholar(id);
		}
	
	public String postAddScholar(Scholar sch) { //Add new scholar details
		return sR.postAddScholar(sch);
		}
	
	public String postUpdateScholar(Scholar sch) {
		return sR.postUpdateScholar(sch);
	}
	
	public String deleteScholar(String id) { //Delete a scholar 
		return sR.deleteScholar(id);
	}
}