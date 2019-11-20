package org.jana.reactive.service;

import org.jana.reactive.document.Student;
import org.jana.reactive.repository.StudentRepo;
import org.jana.reactive.request.SaveStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Flux<Student> getAll() {
        Flux<Student> all = studentRepo.findAll();
        return all;
    }

    public Student save(SaveStudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        Mono<Student> save = studentRepo.save(student);
        return null;
    }

}
