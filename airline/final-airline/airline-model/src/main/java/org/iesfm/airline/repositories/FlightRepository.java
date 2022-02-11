package org.iesfm.airline.repositories;

import org.iesfm.airline.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FlightRepository extends MongoRepository<Flight, Integer>{

    Flight getById(int flight_id);

}
