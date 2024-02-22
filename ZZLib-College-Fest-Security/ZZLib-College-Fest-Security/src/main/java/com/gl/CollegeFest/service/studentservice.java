
package com.gl.CollegeFest.service;

import java.util.List;

import com.gl.CollegeFest.entity.student;

public interface studentservice {
	public List<student> findAll();
	
	public student findById(int id);
	
	public void save(student theStudent);
	
	public void deleteByid(int id);

}
