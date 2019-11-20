package org.jana.reactive.repository;

import org.jana.reactive.document.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends ReactiveMongoRepository<Student, String> {



}
