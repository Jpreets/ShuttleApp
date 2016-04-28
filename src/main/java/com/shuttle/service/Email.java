package com.shuttle.service;

/**
 *
 * @author baldeep
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Email {
    
    @Autowired
    private JavaMailSender mailSender;


    @Async
    public void sendMail(String from, String to, String subject, String msg) throws InterruptedException {
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(subject);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(msg, true);
            mailSender.send(message);
            System.out.println("Inside mail");
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
