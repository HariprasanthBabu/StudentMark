package com.example.studentmarksheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.studentmarksheet.entity.StudentMark;

public interface MarkRepository extends JpaRepository<StudentMark, Integer> {
//	@Query(value="select ?+? from prod_db.mark_sheet where id=?",nativeQuery=true)
//	public int avg(int id);
}
