package com.shoesobjects.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoesobjects.model.Contact;
import com.shoesobjects.repository.ContactRepository;

@Controller
public class ContactWebController {
	
	@Autowired
	private ContactRepository contactRepo;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String contactForm() {
		return "contactform";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String contactSubmitted(HttpServletRequest request, Model model) {
		Contact contact = new Contact();
		contact.setFirstName(request.getParameter("firstName"));
		contact.setLastName(request.getParameter("lastName"));
		contact.setEmail(request.getParameter("email"));
		contact.setPhoneNumber(request.getParameter("phone"));
		contact.setDate(getDateTimestamp());
		contactRepo.saveAndFlush(contact);

		return "thankyou";
	}
	
	private static String getDateTimestamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}

}
