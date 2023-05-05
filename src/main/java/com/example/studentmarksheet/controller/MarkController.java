package com.example.studentmarksheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.studentmarksheet.entity.StudentMark;
import com.example.studentmarksheet.service.MarkService;

@RestController
public class MarkController {
	@Autowired
	MarkService markSer;

	@PostMapping(value = "/addmarks")
	public String add(@RequestBody StudentMark s) {
		return markSer.add(s);
	}

	@GetMapping(value = "getvalueMark/{id}")
	public StudentMark getvalue(@PathVariable int id) {
		return markSer.getvalue(id);
	}

	@DeleteMapping(value = "/deleteidMark/{id}")
	public String deleteId(@PathVariable int id) {
		return markSer.deleteId(id);
	}

	@PostMapping(value = "/addAllMark")
	public String addallEmployee(@RequestBody List<StudentMark> s) {
		return markSer.addallStudent(s);
	}

	@GetMapping(value = "/getAllMark")
	public List<StudentMark> getAll() {
		return markSer.getAll();
	}

	@PutMapping(value = "/updateMarkvalue")
	public String update(@RequestBody StudentMark id) {
		return markSer.update(id);
	}

//	@PostMapping(value="/total")
//	public int total(int a, int b) {
//		return markSer.total(a, b);
//	}
	@PostMapping(value = "semtotal")
	public String semtotal(@RequestBody StudentMark stud) {
		int temp1 = stud.getSem1Practical() + stud.getSem1Theory();
		int temp2 = stud.getSem2Practical() + stud.getSem2Theory();
		stud.setSem1Total(temp1);
		stud.setSem2Total(temp2);
		return markSer.semtotal(stud);
	}

	@GetMapping(value = "/totalsem1/{id}")
	public int totalsem1(@PathVariable int id) {
		int temp = markSer.getvalue(id).getSem1Practical();
		int temp1 = markSer.getvalue(id).getSem1Theory();
		int tot = temp + temp1;
		markSer.getvalue(id).setSem2Total(tot);
		return markSer.totalsem1(id);
	}

	@GetMapping(value = "/totalsem2/{id}")
	public int totalsem2(@PathVariable int id) {
		int temp = markSer.getvalue(id).getSem2Practical();
		int temp1 = markSer.getvalue(id).getSem2Theory();
		int tot = temp + temp1;
		markSer.getvalue(id).setSem2Total(tot);
		return markSer.totalsem2(id);
	}
	@GetMapping(value="overall/{id}")
	public int overall(@PathVariable int id) {
		int temp=markSer.totalsem1(id);
		int temp1=markSer.totalsem2(id);
		return temp+temp1;
	}

	

}
