package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.Electricity;
import com.web.service.ElectricityService;

@RestController
@CrossOrigin(origins={"*"})
public class ElectricityController 
{
	@Autowired
    private ElectricityService electricityService;
	
	@PostMapping("/save")
	public String  saveData(@RequestBody Electricity electricity)
	{
		Electricity s1 = electricityService.saveRecord(electricity);
		String message = null;
		if(s1 != null) 
		{
			message = "Data Inserted Successfully.......";
			
		}
		else {
			message = "Data Inserted Failed.......";

		}
		
		return message;
	}
	@GetMapping("/get/{cid}")
	public Electricity getOneRecord(@PathVariable int cid) 
	{
		Electricity get = electricityService.getOneRecord(cid);
		return get;
	}
	@GetMapping("/getAll")
	public List<Electricity> getAll()
	{
		List<Electricity> getAll = electricityService.getAllRecord();
		return getAll;
	}
	@DeleteMapping("/deleteRecord/{cid}")
	public void deleteRecord(@PathVariable int cid) 
	{
	    electricityService.deleteRecord(cid);
		
	}
	@PutMapping("/updateRecord/{cid}")
	public Electricity updatePage(@PathVariable int  cid, @RequestBody Electricity electricity) {
		Electricity update = electricityService.updateRecord(electricity, cid);
		return  update ;
	}
	


}
