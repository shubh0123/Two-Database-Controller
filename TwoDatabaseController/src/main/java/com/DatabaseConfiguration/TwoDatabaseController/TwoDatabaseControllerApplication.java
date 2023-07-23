package com.DatabaseConfiguration.TwoDatabaseController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.database1.config")
@ComponentScan("com.database2.config")
@ComponentScan("com.DatabaseController")
@ComponentScan("com.database1.StudentService")
@ComponentScan("com.database2.FacultyService")


@SpringBootApplication
public class TwoDatabaseControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoDatabaseControllerApplication.class, args);
	}

}
