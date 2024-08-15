package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import enums.BiologicalSex;
import utils.MyFileLogWriter;

public class Nurse extends StaffMember{
	
	private int licenseNumber;


	// Constructors
	public Nurse(int id, String firstName, String lastName, Date birthDate, String address, String phoneNumber,
				 String email, String gender, Date workStartDate, HashSet<Department> departments, double salary,
				 int licenseNumber, String username, String password) {
		super(id, firstName, lastName, birthDate, address, phoneNumber, email, gender, workStartDate, departments, salary,
				username, password);
		this.licenseNumber = licenseNumber;
	}

	public Nurse(int id, String firstName, String lastName, Date birthDate, String address, String phoneNumber,
				 String email, String gender, Date workStartDate, double salary, int licenseNumber, String username, String password) {
		super(id, firstName, lastName, birthDate, address, phoneNumber, email, gender, workStartDate, salary,
				username, password);
		this.licenseNumber = licenseNumber;
	}

	//getters
	public int getLicenseNumber() {
		return licenseNumber;
	}


	//setters
	public void setLicenseNumber(int licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	//toString based on the super.toString()
	@Override
	public String toString() {
		return "Nurse ["+ super.toString()+", licenseNumber=" + licenseNumber 
				+  "]";
	}
	
	

}
