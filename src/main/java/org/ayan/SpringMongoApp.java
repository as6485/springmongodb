package org.ayan;

import org.ayan.document.Gender;
import org.ayan.document.Student;
import org.ayan.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class SpringMongoApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApp.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Student student = new Student("Ayan", "Sengupta", "as6485v3@gmail.com", Gender.MALE);
            //usingMongoTemplate(studentRepository, mongoTemplate, student);

            //using MongoRepository
            studentRepository.findStudentByEmail("as6485v3@gmail.com").ifPresentOrElse(
                    s -> {
                        System.out.println(s + " document already exists with this email");
                    },
                    () -> {
                        studentRepository.insert(student);
                    }
            );
        };
    }

    private static void usingMongoTemplate(StudentRepository studentRepository, MongoTemplate mongoTemplate, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is("as6485@gmail.com"));
        List<Student> existingStudent = mongoTemplate.find(query, Student.class);
        if (existingStudent.size() > 1) {
            System.out.println("Document already exists with this email");
        } else {
            studentRepository.insert(student);
        }
    }
}