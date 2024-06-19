package asif.rest.api.data;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class User {
	
	private int id;
	private String name;
	private LocalDate dob;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}
