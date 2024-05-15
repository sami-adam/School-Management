package com.schoolsp.school.controllers;

import com.schoolsp.school.dto.MailSenderDTO;
import com.schoolsp.school.services.MailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class MailSenderController {
    private MailSenderService mailSenderService;
    MailSenderController(MailSenderService mailSenderService){
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/sendMail")
    public ResponseEntity<Map<String, String>> sendMail(@RequestBody MailSenderDTO mailSenderDTO){
        Map<String, String> response = new HashMap<>();
        try{
            mailSenderService.sendEmail(mailSenderDTO.getEmailTo(), mailSenderDTO.getSubject(), mailSenderDTO.getContent());
            response.put("message", "Mail Sent Successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.put("message", "Mail Sending Failed");
            return ResponseEntity.badRequest().body(response);
        }

    }
}
