package com.assessments.contactsapi.domain;

import com.assessments.contactsapi.models.Contact;

public class Domain {

    public static Contact getContact (){
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("Leo");
        return contact;
    }
}
