package com.database1.StudentService;

import com.database1.StudentRepository.StudentRepository;
import com.database1.entity.students.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public String insert(Students students){
        repo.save(students);
        return "Data Inserted";
    }
    public List<Students> findAll(){
       return  repo.findAll();


    }

}
