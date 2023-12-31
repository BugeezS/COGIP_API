package com.becode.accountingapi.controllers;

import com.becode.accountingapi.models.Company;
import com.becode.accountingapi.models.Contact;
import com.becode.accountingapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/contacts")
public class ContactController {
    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }
}
