package com.assessments.contactsapi.services;

import com.assessments.contactsapi.models.Contact;

public interface ContactService {
    Contact createOne (Contact request);
    Contact findById(Integer contactId);

    Contact updateOne (Integer contactId, Contact request);

    void deleteOne (Integer contactId);
}
