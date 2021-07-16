package edu.utn.FinalAvanzada.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "employees")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String  lastName;

    @Column(name = "age")
    private int age;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "city")
    private City city;

}
