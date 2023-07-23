package com.DatabaseController;

import com.database1.StudentService.StudentService;
import com.database1.entity.students.Students;
import com.database2.FacultyService.FacultyService;
import com.database2.entity.faculty.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabaseController {
    @Autowired
    public StudentService studentService;

    @Autowired
    public FacultyService facultyService;


    @GetMapping("students/findAll")
    public List<Students> findAll(){
      List<Students>students= studentService.findAll();
        System.out.println(students);
        return students;

    }

    @GetMapping("students/insert")
    public String insert(){
       String message= studentService.insert(new Students(4l,"Shresth","xyz","yx",9307582929l));
       return message;
    }
    @GetMapping("facultyInsert")
    public String facInsert(){
        String message=facultyService.facInsert(new Faculty("Sachin","Maths",9307582929l));
        return message;
    }

    @GetMapping("faculty/findAll")
    public List<Faculty> facFindAll(){
       List<Faculty>faculties= facultyService.findAll();
       System.out.println(faculties);
       return faculties;

    }
}
