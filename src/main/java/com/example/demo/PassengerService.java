package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger addNewPassenger(Passenger passenger){
        return passengerRepository.insert(passenger);
    }

    public boolean exists(String id){
        return passengerRepository.existsById(id);
    }
}
