package org.jana.reactive.controller;

import org.jana.reactive.document.Student;
import org.jana.reactive.request.SaveStudentRequest;
import org.jana.reactive.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public void save(@RequestBody SaveStudentRequest request) {
        studentService.save(request);
    }

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAll() {
        return studentService.getAll();
    }

}
