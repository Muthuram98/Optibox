package Mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import commonMethods.Utils;

import java.util.Properties;

public class EmailSender {

    public static void sendTestSummaryEmail(String recipient, String subject, String content, String filePath) {

        String sender_mail = Utils.getDataFromTestConfig("Sender");
        String sender_password = Utils.getDataFromTestConfig("Password");

        // Set up mail server and properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender_mail, sender_password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender_mail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Add the email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/html");
            multipart.addBodyPart(messageBodyPart);

            // Add attachment if filePath is provided
            if (filePath != null && !filePath.isEmpty()) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(filePath);
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                attachmentBodyPart.setFileName(source.getName());
                multipart.addBodyPart(attachmentBodyPart);
            }

            // Set the complete message parts
            message.setContent(multipart);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
