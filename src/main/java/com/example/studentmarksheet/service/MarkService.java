package com.example.studentmarksheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.studentmarksheet.dao.MarkDao;
import com.example.studentmarksheet.entity.StudentMark;

@Service
public class MarkService {
	@Autowired
	MarkDao markDao;

	public String add(StudentMark s) {
		return markDao.add(s);
	}

	public StudentMark getvalue(int id) {
		return markDao.getvalue(id);
	}

	public String deleteId(int id) {
		return markDao.deleteId(id);
	}

	public String addallStudent(List<StudentMark> s) {
		return markDao.addallStudent(s);
	}

	public List<StudentMark> getAll() {
		return markDao.getAll();
	}

	public String update(StudentMark id) {
		return markDao.update(id);
	}

//	public int total(int a, int b) {
//		return markDao.total(a, b);
//	}
	public String semtotal(StudentMark stud) {
		return markDao.semtotal(stud);
	}

	public int totalsem1(int id) {
		return markDao.getvalue(id).getSem1Total();
	}
	public int totalsem2(int id) {
		return markDao.getvalue(id).getSem2Total();
	}

}
