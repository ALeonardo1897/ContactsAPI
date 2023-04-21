package com.assessments.contactsapi.controllers;

import com.assessments.contactsapi.domain.Domain;
import com.assessments.contactsapi.models.Contact;
import com.assessments.contactsapi.services.ContactService;
import com.assessments.contactsapi.services.impl.ContactServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest
class ContactControllerTest {

    @InjectMocks
    private ContactController contactController;

    @Mock
    private ContactServiceImpl contactService;

    @Test
    void findOne() {
        Mockito.when(contactService.findById(ArgumentMatchers.anyInt())).thenReturn(Domain.getContact());
        ResponseEntity<Contact> expected = contactController.findOne(ArgumentMatchers.anyInt());
        Assertions.assertEquals(expected, new ResponseEntity<>(Domain.getContact(), HttpStatus.OK));
    }

    @Test
    void createOne() {
        Mockito.when(contactService.createOne(ArgumentMatchers.any())).thenReturn(Domain.getContact());
        ResponseEntity<Contact> expected = contactController.createOne(ArgumentMatchers.any());
        Assertions.assertEquals(expected, new ResponseEntity<>(Domain.getContact(), HttpStatus.CREATED));
    }
}