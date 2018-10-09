package com.shoesobjects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoesobjects.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}
