package com.project.util;

import com.project.model.Email;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class EmailUtil {

    private static final String EMAIL_USERNAME = "your-email@example.com";
    private static final String EMAIL_PASSWORD = "your-email-password";
    private static final String EMAIL_HOST = "smtp.example.com";
    private static final int EMAIL_PORT = 587;

    public static void sendEmail(Email email) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", EMAIL_HOST);
        properties.put("mail.smtp.port", EMAIL_PORT);

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));

            for (String recipient : email.getRecipients()) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }

            message.setSubject(email.getSubject());

            if (email.getAttachmentPath() != null) {
                // Attach file to the email
                // ...
            }

            message.setText(email.getBody());

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
