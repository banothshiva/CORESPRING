package com.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Electricity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String  cname;
	private int current_reading;
	private int previous_reading;
	private int units;
	private double totalBill;
	
	// PDC 
	
	public Electricity() {
		super();
	}
	//PPC

	public Electricity(int cid, String cname, int current_reading, int previous_reading, int units, int totalBill) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.current_reading = current_reading;
		this.previous_reading = previous_reading;
		this.units = units;
		this.totalBill = totalBill;
	}
	// PSM + PGM

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCurrent_reading() {
		return current_reading;
	}

	public void setCurrent_reading(int current_reading) {
		this.current_reading = current_reading;
	}

	public int getPrevious_reading() {
		return previous_reading;
	}

	public void setPrevious_reading(int previous_reading) {
		this.previous_reading = previous_reading;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double total) {
		this.totalBill = total;
	}
	// to string

	@Override
	public String toString() {
		return "Electricity [cid=" + cid + ", cname=" + cname + ", current_reading=" + current_reading
				+ ", previous_reading=" + previous_reading + ", units=" + units + ", totalBill=" + totalBill + "]";
	}
	
	

}
