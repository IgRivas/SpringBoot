package com.example.apidemo.Repository;

import com.example.apidemo.Model.Task_Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task_Entidad, Long> {
}
