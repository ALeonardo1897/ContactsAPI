package com.assessments.contactsapi.services.impl;

import com.assessments.contactsapi.exceptions.ConflictException;
import com.assessments.contactsapi.exceptions.NotFoundException;
import com.assessments.contactsapi.models.Contact;
import com.assessments.contactsapi.repositories.ContactRepository;
import com.assessments.contactsapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createOne(Contact request) {
        if (contactRepository.existsById(request.getId())) throw new ConflictException();
        return contactRepository.save(request);
    }

    @Override
    public Contact findById(Integer contactId) {
        return contactRepository.findById(contactId).orElseThrow(()-> new NotFoundException());
    }

    @Override
    public Contact updateOne(Integer contactId, Contact request) {
        Contact contact = findById(contactId);
        contact.setId(contactId);
        contact.setName(request.getName());
        return contactRepository.save(contact);
    }

    @Override
    public void deleteOne(Integer contactId) {
        Contact contact = findById(contactId);
        contactRepository.delete(contact);
    }
}
