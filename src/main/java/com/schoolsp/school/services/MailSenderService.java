package com.schoolsp.school.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService {
    private JavaMailSender mailSender;
    MailSenderService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    @PreAuthorize("hasRole('USER')")
    public void sendEmail(String email, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("test@gmail.com");
        helper.setTo(email);

        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }
}
