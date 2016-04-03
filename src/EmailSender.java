/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ธนพล
 */
public class EmailSender {
    public static boolean sendMail(String from,String password,String message,String to[]) throws MessagingException{
        String host = "smtp.live.com"; //ประเภทผู้ส่งเป็นแบบ live (hotmail)
        Properties props = System.getProperties(); 
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.host", host); 
        props.put("mail.smtp.user", from); //Email ของผู้ส่ง
        props.put("mail.smtp.password", password); //password ของ Email ผู้ส่ง
        props.put("mail.smtp.port", 587); // port ในการสื่อสาร
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
        
        try{
            mimeMessage.setFrom(new InternetAddress(from)); 
            InternetAddress[] toAddress = new InternetAddress[to.length]; 
            for(int i=0;i<to.length;i++){
                toAddress[i] = new InternetAddress(to[i]);
            }
            for(int i=0;i<toAddress.length;i++){
                mimeMessage.addRecipient(RecipientType.TO, toAddress[i]);
            }
            //add Subject
            mimeMessage.setSubject("Personal Libraly"); //กำหนด หัวเรื่อง
            //set message to mimeMessage
            mimeMessage.setText(message); //กำหนดข้อความที่ส่ง
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
            transport.close();
            return true;
        }catch(MessagingException me){
            me.printStackTrace();
        }
        return false;
    }
}
