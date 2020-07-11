package edu.utn.FinalAvanzada.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {
    String code;
    String name;
}
