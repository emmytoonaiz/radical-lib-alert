/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easycoop.radical.lib.alert;

import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;

/**
 *
 * @author emmanuel.idoko
 */
public class APITest {

    public static void main(String[] args) throws MessagingException {

//        Authentication auth = new Authentication();
//       // auth.setUsername("emmanuel.idoko");
//        //auth.setPassword("Password@1");
//        MessageDetails msg = new MessageDetails();
//
//        msg.setFrom("emmanuel.idoko@sd1.emailtesthub.com");
//        msg.setText("This is just a test email from exchange point email API.");
//        msg.setTo("emmytoonaiz@gmail.com");
//        msg.setSubject("Texting plain email.");
//
//        new EmailResource().sendSingleEmail(auth, msg);
//        Authentication auth = new Authentication();
//        auth.setUsername("emmanuel.idoko");
//        auth.setPassword("Password@1");
//        MessageDetails msg = new MessageDetails();
//        msg.setFrom("INFOSMS");
//        msg.setMemberName("Akinwale Agbaje");
//        msg.setText("Dear " + msg.getMemberName() + ",This is just a test message from exchange point API.");
//        msg.setTo("+2349098123438");
//        new SmsResource().sendSingleText(auth, msg);
        //new SmsResource().querySentMessages();
        //System.out.println("encoded string::" + Util.getEncodeCredentials());
        EmailSender sender =  new EmailSender();
        List<String> emails = new ArrayList<>();
        emails.add("emmanuel.idoko@africaprudential.com");
        emails.add("gbolahan.folarin@africaprudential.com");
        //javaEmail.createEmailMessage();
        sender.sendBulkEmail("killmewithdlord", "desterity", emails, "Java Email API", "<h1>This is an email sent by JavaMail API, testing bulk email with html</h1>");
        

    }
}
