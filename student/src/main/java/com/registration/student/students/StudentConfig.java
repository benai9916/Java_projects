package com.registration.student.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Students benai = new Students(
                    "benai",
                    "benai@gmail.com",
                    LocalDate.of(1998, Month.AUGUST, 22)
            );

            Students vaishnavi = new Students(
                    "vaishnavi",
                    "vaishnavi@gmail.com",
                    LocalDate.of(2000, Month.AUGUST, 22)
            );

            repository.saveAll(Arrays.asList(benai, vaishnavi));
        };
    }
}
