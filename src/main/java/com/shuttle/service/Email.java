/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.service;

/**
 *
 * @author baldeep
 */
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@PropertySource("classpath:EmailConfig.properties")
@Component
public class Email {

    @Value("${email.username}")
    private String username;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * This method triggers the email in background thread i.e. the mail is sent
     * asynchronously
     *
     * @param to Email to whom mail has to be sent
     * @param subject Subject of the email Messages
     * @param msg Message body to be sent along with email
     * @throws InterruptedException
     */
    @Async
    public void sendMail(String to, String subject, String msg) throws InterruptedException {
        try {

            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(subject);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(username);
            helper.setTo(to);
            helper.setText(msg, true);
            mailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

}
