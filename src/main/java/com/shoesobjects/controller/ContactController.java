package com.shoesobjects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoesobjects.model.Contact;
import com.shoesobjects.repository.ContactRepository;


@RestController
@RequestMapping("api/v1")
public class ContactController {

	@Autowired
	private ContactRepository contactRepo;
	
	@RequestMapping("/")
	public String home() {
		return "Running";
	}
	
	@RequestMapping(value="contacts", method=RequestMethod.GET)
	public List<Contact> list() {
		return contactRepo.findAll();
	}
	
	@RequestMapping(value="contact", method=RequestMethod.POST)
	public Contact create(@RequestBody Contact contact) {
		return contactRepo.saveAndFlush(contact);
	}
}
