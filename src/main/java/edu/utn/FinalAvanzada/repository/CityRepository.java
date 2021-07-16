package edu.utn.FinalAvanzada.repository;

import edu.utn.FinalAvanzada.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
}