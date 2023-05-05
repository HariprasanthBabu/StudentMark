package com.example.studentmarksheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.studentmarksheet.entity.StudentMark;
import com.example.studentmarksheet.repository.MarkRepository;

@Repository
public class MarkDao {
	@Autowired
	MarkRepository markRepo;

	public String add(StudentMark s) {
		markRepo.save(s);
		return "Successfully saved";
	}

	public StudentMark getvalue(int id) {
		return markRepo.findById(id).get();
	}

	public String deleteId(int id) {
		markRepo.deleteById(id);
		return "Deleted";
	}

	public String addallStudent(List<StudentMark> s) {
		markRepo.saveAll(s);
		return "Added";
	}

	public List<StudentMark> getAll() {
		return markRepo.findAll();
	}

	public String update(StudentMark s) {
		markRepo.save(s);
		return "Updated";
	}

//	public int total(int a, int b) {
//		return markRepo.total(a);
//	}

	public String semtotal(StudentMark stud) {
		markRepo.save(stud);
		return "Successfully added";

	}
//	public int avg(int id) {
//		return markRepo.avg(id);
//	}

}
