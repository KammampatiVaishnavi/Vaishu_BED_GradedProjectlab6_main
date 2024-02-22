
package com.gl.CollegeFest.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_Name")
	private final String firstName;
	@Column(name = "Last_Name")
	private final String last_Name;
	private final String course;
	private final String country;
	public student(String firstName, String last_Name, String course, String country) {
		super();
		this.firstName = firstName;
		this.last_Name = last_Name;
		this.course = course;
		this.country = country;
	}




}