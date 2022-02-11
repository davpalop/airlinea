package org.iesfm.airline.controllers;

import org.iesfm.airline.Flight;
import org.iesfm.airline.exceptions.FlightNotFoundException;
import org.iesfm.airline.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public FlightService getFlightService() {
        return flightService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flights")
    public List<Flight> listFlights() {
        return flightService.listFlights();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flights")
    public void insertFlight(@RequestBody Flight flight) throws FlightNotFoundException {
        if (flightService.getById(flight.getId()) == null) {
            flightService.insertFlight(flight);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía el vuelo");
        }
    }
}
