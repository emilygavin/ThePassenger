package com.example.demo;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passengers")
@AllArgsConstructor
public class PassengerController {

    private static final Logger log = LoggerFactory.getLogger(PassengerController.class);
    private final PassengerService passengerService;

    @GetMapping
    public List<Passenger> fetchAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Passenger registerNewPassenger (@RequestBody Passenger passenger){
        if(!passengerService.exists(passenger.getID())) {
            if(passenger.getAge() >= 16) {
                if(passenger.getName().length() > 3){
                    if(passenger.getPhoneNumber().length() > 7){
                        if(passenger.getTitle() == "Miss" || passenger.getTitle() == "Mr" || passenger.getTitle() == "Mrs"){
                            return passengerService.addNewPassenger(passenger);
                        }
                        else {
                            log.info("Not a valid title (must be Miss, Mr or Mrs)");
                            throw new IllegalStateException("Not a valid title (must be Miss, Mr or Mrs)");
                        }
                    }
                    else{
                        log.info("Passenger phone number too short (must be greater than 7 characters)");
                        throw new IllegalStateException("Passenger phone number too short (must be greater than 7 characters)"); }
                }
                else{
                    log.info("Passenger name too short (must be greater than 3 characters)");
                    throw new IllegalStateException("Passenger name too short (must be greater than 3 characters)"); }
            }
            else{
                log.info("Passenger cannot be under the age of 16");
                throw new IllegalStateException("Passenger cannot be under the age of 16"); }
        }
        else{ log.info("id already exists");
            throw new IllegalStateException("id already exists"); }
    }
}
