package com.example.MoviesDemo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class MoviesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesDemoApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@GetMapping("/")
	public String homePage() {
		return "admin.html"; // This refers to home.html in the templates director
	}
}



