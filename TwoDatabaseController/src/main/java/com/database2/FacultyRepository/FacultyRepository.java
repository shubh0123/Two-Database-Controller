package com.database2.FacultyRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database2.entity.faculty.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long>{

}
