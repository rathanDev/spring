package org.jana.reactive.controller;

import org.jana.reactive.document.Student;
import org.jana.reactive.request.SaveStudentRequest;
import org.jana.reactive.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Student save(@RequestBody SaveStudentRequest request) {
        studentService.save(request);
        return null;
    }

    @GetMapping("/all")
    public Flux<Student> getAll() {
        Flux<Student> all = studentService.getAll();
        return all;
    }

}
