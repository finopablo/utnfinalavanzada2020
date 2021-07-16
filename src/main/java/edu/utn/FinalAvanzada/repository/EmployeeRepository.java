package edu.utn.FinalAvanzada.repository;

import edu.utn.FinalAvanzada.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT E FROM employees E WHERE E.city.iata_code = :code")
    List<Employee> findEmployeeByCity(String code, Pageable pageable);

}
