package com.example.apidemo.Repository;

import com.example.apidemo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Usuario, Integer> {
}
