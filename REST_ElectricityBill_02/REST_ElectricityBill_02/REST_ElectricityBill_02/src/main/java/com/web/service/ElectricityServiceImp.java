package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.Electricity;
import com.web.repo.ElectricityRepo;
@Service
public class ElectricityServiceImp implements ElectricityService {

	@Autowired
	   private ElectricityRepo electricityRepo;
		@Override
		public Electricity saveRecord(Electricity electricity)
		{
			int uts =0;
			double total = 0.0;
			uts = electricity.getCurrent_reading() - electricity.getPrevious_reading();
			electricity.setUnits(uts);
			/// condition for the 
			if(uts > 300)
			{
				total = uts*1.75;
			}
			else if (uts >= 300 && uts <=500) 
			{
			  total = uts * 3.75;	
			}
			else if (uts > 500)
			{
				total = uts* 7.25;
			}
			electricity.setTotalBill(total);
			Electricity e = electricityRepo.save(electricity);
			return e;
		}


	@Override
	public Electricity updateRecord(Electricity electricity, int cid) 
	{
		Electricity oldRecord = electricityRepo.findById(cid).get();
		oldRecord.setCname(electricity.getCname());
		oldRecord.setCurrent_reading(electricity.getCurrent_reading());
		oldRecord.setPrevious_reading(electricity.getPrevious_reading());
		int uts =0;
		double total = 0.0;
		uts = electricity.getCurrent_reading() - electricity.getPrevious_reading();
		electricity.setUnits(uts);
		/// condition for the 
		if(uts < 300)
		{
			total = uts*1.75;
		}
		else if (uts >= 300 && uts <=500) 
		{
		  total = uts * 3.75;	
		}
		else if (uts > 500)
		{
			total = uts* 7.25;
		}
		oldRecord.setUnits(uts);
		oldRecord.setTotalBill(total);
		Electricity upd = electricityRepo.save(oldRecord);
		return upd;
	}

	@Override
	public void deleteRecord(int cid) 
	{
		electricityRepo.deleteById(cid);

	}

	@Override
	public Electricity getOneRecord(int cid)
	{
		Electricity get =electricityRepo.findById(cid).get();
		return get;
	}

	@Override
	public List<Electricity> getAllRecord()
	{
		List<Electricity> getAll = electricityRepo.findAll();
		return getAll;
	}

}
