package com.example.apidemo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacto")
    private Integer id;

    private String nombre;
    @Column(name = "fechanac")
    private LocalDate fechaNacimiento;

    private String celular;
    private String email;
}
