package org.iesfm.airline.repositories;
import org.iesfm.airline.Case;
import org.iesfm.airline.Flight;
import org.iesfm.airline.Passenger;
import org.iesfm.airline.PassengerId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PassengerRepository extends MongoRepository<Passenger, PassengerId>{

    Passenger getByPassengerId(PassengerId passengerId);

    List<Case> getByCases(PassengerId passengerId);

//    Case getByCase(PassengerId passengerId);

}
