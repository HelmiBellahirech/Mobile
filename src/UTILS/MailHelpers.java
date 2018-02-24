/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILS;

import MODEL.Cours;
import MODEL.Professeur;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author nadaghanem
 */
public class MailHelpers {

    public static boolean sendMail(String receipient, Cours cours, Professeur prof) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");        
        props.put("mail.smtp.host", "outlook.office365.com");
        Session session = Session.getInstance(props, null);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("slahghannem@hotmail.com");
            msg.setRecipients(Message.RecipientType.TO,
                    receipient);
            msg.setSubject("Nouveau cours ajouté!");
            msg.setSentDate(new Date());
            msg.setText("Bonjour,\nLe cours " + cours.getMatiere() + " a été ajouté par le Prof " + prof.getNom());
            Transport.send(msg, "slahghannem@hotmail.com", "98459183");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
            return false;
        }
        return true;
    }
}
