package edu.utn.FinalAvanzada.Repository;

import edu.utn.FinalAvanzada.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT e.name AS FIRST_NAME" +
            ", e.lastname AS LAST_NAME, " +
            "e.age AS AGE," +
            "e.city AS CITY_CODE " +
            "FROM employees e " +
            "WHERE e.age " +
            "BETWEEN :from AND :to")
    List<Employee> findByAgeRange(@Param("from")int from,
                                  @Param("to")int to);
}
