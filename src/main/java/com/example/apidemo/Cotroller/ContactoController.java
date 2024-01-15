package com.example.apidemo.Cotroller;

import com.example.apidemo.Model.Usuario;
import com.example.apidemo.Repository.ContactoRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ContactoController {
    private final ContactoRepository contactoRepository;

    public ContactoController(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @GetMapping
    public List<Usuario> listContacto(){
        return contactoRepository.findAll();
    }
}
