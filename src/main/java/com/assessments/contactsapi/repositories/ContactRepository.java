package com.assessments.contactsapi.repositories;

import com.assessments.contactsapi.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Override
    boolean existsById(Integer integer);
}
