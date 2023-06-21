package lasilu.util;

import lasilu.model.Email;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.util.Properties;

public class EmailUtil {

    // private static String EMAIL_SENDER = "koncipandawa";
    // private static String PASSWORD_SENDER = "koncipandawa5";
    // private static String EMAIL_HOST = "smtp.gmail.com";
    // private static int EMAIL_PORT = 587;
    
    // public static void setEmailSender(String emailSender) {
    //   EMAIL_SENDER = emailSender;
    // }

    public static void sendEmail(String host, int port, final String username, final String password,
        String recipient, String subject, String content) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

         try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // try {
        //     Message message = new MimeMessage(session);
        //     message.setFrom(new InternetAddress(EMAIL_SENDER));

        //     for (String recipient : email.getRecipients()) {
        //         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        //     }

        //     message.setSubject(email.getSubject());

        //     if (email.getAttachmentPath() != null) {
        //         // Attach file to the email
        //        MimeBodyPart attachmentBodyPart = new MimeBodyPart();

        //       // Set the data source to the attachment file
        //       FileDataSource fileDataSource = new FileDataSource(email.getAttachmentPath());
        //       attachmentBodyPart.setDataHandler(new DataHandler(fileDataSource));
        //       attachmentBodyPart.setFileName(fileDataSource.getName());

        //       // Create a multipart object and add the attachment body part
        //       Multipart multipart = new MimeMultipart();
        //       multipart.addBodyPart(attachmentBodyPart);

        //       // Set the multipart as the content of the message
        //       message.setContent(multipart);               // ...
        //     }

        //     message.setText(email.getBody());

        //     Transport.send(message);
        //     System.out.println("Email berhasil successfully!");
        // } catch (MessagingException e) {
        //     e.printStackTrace();
        // }
    }
    public static void main(String[] args) {
        String host = "DESKTOP-KBVPI7F";
        int port = 587; // Port number for your SMTP server
        String username = "koncipandawa@gmail.com";
        String password = "koncipandawa5";
        String recipient = "princenizroh@gmail.com";
        String subject = "Test Email";
        String content = "This is a test email.";

        sendEmail(host, port, username, password, recipient, subject, content);
    }
}