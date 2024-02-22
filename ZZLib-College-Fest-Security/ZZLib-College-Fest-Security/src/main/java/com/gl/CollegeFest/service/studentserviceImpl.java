
package com.gl.CollegeFest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.CollegeFest.entity.student;
import com.gl.CollegeFest.repository.StudentRepository;

@Service

public class studentserviceImpl implements studentservice{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public student findById(int id) {
		Optional<student> results =  studentRepository.findById(id);
		student theStudent = null;
		if(results.isPresent())
			theStudent= results.get();
			
		return theStudent;
	}

	@Override
	public void save(student theStudent) {
		studentRepository.save(theStudent);
		
	}

	@Override
	public void deleteByid(int id) {
		studentRepository.deleteById(id);
	}

}
