package lasilu.util;

import lasilu.model.Email;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.util.Properties;

public class EmailUtil {

    private static String EMAIL_SENDER = "koncipandawa@gmail.com";
    private static String PASSWORD_SENDER = "xshxgxpbtcybawyw";
    private static String EMAIL_HOST = "smtp.gmail.com";
    private static int EMAIL_PORT = 587;
    
    public static void setEmailSender(String emailSender) {
      EMAIL_SENDER = emailSender;
    }

    public static void sendEmail(Email email) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", EMAIL_HOST);
        properties.put("mail.smtp.user", EMAIL_SENDER);
        properties.put("mail.smtp.password", PASSWORD_SENDER);
        properties.put("mail.smtp.port", EMAIL_PORT);
        properties.put("mail.smtp.ssl.trust", EMAIL_HOST);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_SENDER, PASSWORD_SENDER);
            }
        });

        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));

            for (String recipient : email.getRecipients()) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }

            message.setSubject(email.getSubject());

            if (email.getAttachmentPath() != null) {
                // Attach file to the email
               MimeBodyPart attachmentBodyPart = new MimeBodyPart();

              // Set the data source to the attachment file
              FileDataSource fileDataSource = new FileDataSource(email.getAttachmentPath());
              attachmentBodyPart.setDataHandler(new DataHandler(fileDataSource));
              attachmentBodyPart.setFileName(fileDataSource.getName());

              // Create a multipart object and add the attachment body part
              Multipart multipart = new MimeMultipart();
              multipart.addBodyPart(attachmentBodyPart);

              // Set the multipart as the content of the message
              message.setContent(multipart);               // ...
            }

            message.setText(email.getBody());

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}