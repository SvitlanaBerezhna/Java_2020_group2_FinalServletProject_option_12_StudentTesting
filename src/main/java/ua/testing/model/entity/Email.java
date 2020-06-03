package ua.testing.model.entity;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class Email {
    private String to;
    private String subject;
    private String text;

    public Email(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public void sendEmail() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            String propertiesFilePath = System.getProperty("catalina.home") +
                    File.separator + "conf" + File.separator + "mail.properties";
            fis = new FileInputStream(propertiesFilePath);
            property.load(fis);
        } catch (IOException e) {
            System.err.println("Error access to mail properties file!");
        }

        Session session = Session.getDefaultInstance(property);
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
            message.setSubject(this.subject);
            message.setText(this.text);
            message.setFrom(new InternetAddress(property.getProperty("mail.smtp.from")));

            Transport transport = session.getTransport(property.getProperty("mail.transport.protocol"));
            transport.connect(property.getProperty("mail.smtp.username"), property.getProperty("mail.smtp.password"));
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
