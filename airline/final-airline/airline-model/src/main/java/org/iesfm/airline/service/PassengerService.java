package org.iesfm.airline.service;

import org.iesfm.airline.Case;
import org.iesfm.airline.Flight;
import org.iesfm.airline.Passenger;
import org.iesfm.airline.PassengerId;
import org.iesfm.airline.exceptions.FlightNotFoundException;
import org.iesfm.airline.exceptions.PassengerNotFoundException;
import org.iesfm.airline.repositories.FlightRepository;
import org.iesfm.airline.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private PassengerRepository passengerRepository;
    private FlightRepository flightRepository;

    public PassengerService(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    public List<Passenger> listPassengersFromFlight(int flight_id) throws FlightNotFoundException {
        if (!flightRepository.existsById(flight_id)) {
            throw new FlightNotFoundException();
        }
        return passengerRepository.findAll();
    }

    public boolean insertPassenger(Passenger passenger, int flight_id) throws FlightNotFoundException {
        if (!flightRepository.existsById(flight_id)) {
            throw new FlightNotFoundException();
        }
        passengerRepository.insert(passenger);
        return true;
    }

    public boolean insertCase(Case backpack, int flight_id, String nif) throws PassengerNotFoundException, FlightNotFoundException {
        if (!flightRepository.existsById(flight_id)) {
            throw new FlightNotFoundException();
        } else if (passengerRepository.existsById(new PassengerId(nif, flight_id))) {
            throw new PassengerNotFoundException();
        }
        Passenger passenger = passengerRepository.findById(new PassengerId(nif, flight_id)).get();
        passenger.getCases().add(backpack);
        return true;
    }

    public List<Case> listCases(int flightId, String nif) throws PassengerNotFoundException, FlightNotFoundException {
        if (!flightRepository.existsById(flightId)){
            throw new FlightNotFoundException();
        } else if (!passengerRepository.existsById(new PassengerId(nif, flightId))) {
            throw new PassengerNotFoundException();
        }
        return passengerRepository.findById(new PassengerId(nif, flightId)).get().getCases();
    }

    public Passenger getByPassengerId(PassengerId passengerId) {
        return passengerRepository.getByPassengerId(passengerId);
    }

    public Flight getById(int flight_id) {
        return flightRepository.getById(flight_id);
    }

    public List<Case> getByCases(PassengerId passengerId) {
        return passengerRepository.getByCases(passengerId);
    }

//    public Case getByCase(PassengerId passengerId) {
//        return passengerRepository.getByCase(passengerId);
//    }

    
}
