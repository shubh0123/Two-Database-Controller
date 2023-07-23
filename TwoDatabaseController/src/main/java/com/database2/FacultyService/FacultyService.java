package com.database2.FacultyService;

import com.database2.FacultyRepository.FacultyRepository;
import com.database2.entity.faculty.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    public String facInsert(Faculty faculty){
        facultyRepository.save(faculty);
        return "Data Inserted";
    }
    public List<Faculty> findAll(){
        return facultyRepository.findAll();
    }
}
