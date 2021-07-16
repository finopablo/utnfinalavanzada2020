package edu.utn.FinalAvanzada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    String iata_code;
    String city_name;
}
