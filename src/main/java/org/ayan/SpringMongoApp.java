package org.ayan;

import org.ayan.document.Gender;
import org.ayan.document.Student;
import org.ayan.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMongoApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApp.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student student = new Student("Ayan", "Sengupta", "as6485@gmail.com", Gender.MALE);
            studentRepository.insert(student);
        };
    }
}