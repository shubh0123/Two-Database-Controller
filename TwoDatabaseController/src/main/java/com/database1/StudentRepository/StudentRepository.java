package com.database1.StudentRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database1.entity.students.Students;

public interface StudentRepository extends JpaRepository<Students,Long>{

}
