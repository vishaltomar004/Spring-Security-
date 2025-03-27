package com.security.controller;

import com.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

   private List<Student> students = new ArrayList<>(List.of(
           new Student(1,"Atul",90),
           new Student(2,"nikita",50)
   ));

   @GetMapping("/students")
    public  List<Student> getStudent()
   {
       return students;
   }

   @GetMapping("/csrf-token")
   public CsrfToken getToken(HttpServletRequest request)
   {
       return (CsrfToken) request.getAttribute("_csrf");
   }
   @PostMapping("/students")
    public Student addStudent(@RequestBody Student std)
   {
       students.add(std);
       return std;
   }
}
