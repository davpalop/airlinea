package org.iesfm.airline.service;

import org.iesfm.airline.Flight;
import org.iesfm.airline.exceptions.FlightAlreadyCreated;
import org.iesfm.airline.exceptions.FlightNotFoundException;
import org.iesfm.airline.repositories.FlightRepository;
import org.iesfm.airline.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> listFlights() {
        return flightRepository.findAll();
    }

    public boolean insertFlight(Flight flight) throws FlightNotFoundException {
        if (flightRepository.existsById(flight.getId())) {
            try {
                throw new FlightAlreadyCreated();
            } catch (FlightAlreadyCreated e) {
                e.printStackTrace();
            }
        }
        flightRepository.insert(flight);
        return true;
    }

    public Flight getById(int flight_id) {
        return flightRepository.getById(flight_id);
    }

}
