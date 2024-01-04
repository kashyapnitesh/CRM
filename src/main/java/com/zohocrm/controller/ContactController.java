package com.zohocrm.controller;


import com.zohocrm.payload.ContactDto;
import com.zohocrm.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    //http://localhost:8080/api/contacts/7d1fa98f-44e3-4e85-91b4-f89e6282cb44
    @PostMapping("/{leadId}")
    public ResponseEntity<ContactDto> createContact(@PathVariable String leadId){
        ContactDto dto = contactService.createContact(leadId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
