/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easycoop.radical.lib.alert;

import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author emmanuel.idoko
 */
public class EmailSender {

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public void sendBulkEmail(String fromUser, String fromUserEmailPassword, List<String> to_emails, String subject, String emailBody, String template) throws AddressException, MessagingException {

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        for (int i = 0; i < to_emails.size(); i++) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to_emails.get(i)));
        }

        MessageFormat mf = new MessageFormat(template);
        String message_html = mf.format(new Object[]{emailBody});

        emailMessage.setSubject(subject);
        emailMessage.setContent(message_html, "text/html");//for a html email
        //emailMessage.setText(emailBody);// for a text email
        String emailHost = "smtp.gmail.com";

        Transport transport = mailSession.getTransport("smtp");

        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
}