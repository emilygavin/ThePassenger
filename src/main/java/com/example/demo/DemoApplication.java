package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PassengerRepository passengerRepository){
		return args -> {
			//Passenger passengerOne = new Passenger("Miss", "Emily Gavin", "0838674899", 21);

			Passenger passengerTwo = new Passenger("Mr", "Nathan Gray", "0877692870", 21);

			//passengerRepository.insert(passengerOne);

			passengerRepository.insert(passengerTwo);
		};
	}
}
