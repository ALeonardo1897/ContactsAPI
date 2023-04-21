package com.assessments.contactsapi.controllers;

import com.assessments.contactsapi.models.Contact;
import com.assessments.contactsapi.services.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("/contacts/{contactId}")
    public ResponseEntity<Contact> findOne(@PathVariable Integer contactId) {
        return new ResponseEntity<>(contactService.findById(contactId), HttpStatus.OK);
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createOne (@RequestBody Contact request) {
        return new ResponseEntity<>(contactService.createOne(request), HttpStatus.CREATED);
    }

    @PutMapping("/contacts/{contactId}")
    public ResponseEntity<Contact> updateOne (@PathVariable Integer contactId, @RequestBody Contact request) {
        return new ResponseEntity<>(contactService.updateOne(contactId, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<Contact> deleteOne (@PathVariable Integer contactId) {
        contactService.deleteOne(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
