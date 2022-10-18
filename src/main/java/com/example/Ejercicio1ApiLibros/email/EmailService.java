package com.example.Ejercicio1ApiLibros.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

@Service
public class EmailService{
	
	
	@Autowired
	private JavaMailSender mailSender;

//	public void sendEmail(Email emailM) {
//		
//			SimpleMailMessage email = new SimpleMailMessage();
//			email.setFrom("aimarpruebaemail@gmail.com");
//			email.setTo(emailM.getTo());
//			email.setSubject(emailM.getSubject());
//			email.setText(emailM.getText());
//			
//
//			mailSender.send(email);
//				
//		
//	}
	
	 public void sendEmail(Email emailM)  {
					try {
						MimeMessage message = mailSender.createMimeMessage();
						MimeMessageHelper helper = new MimeMessageHelper(message, true);
						helper.setFrom("aimarpruebaemail@gmail.com");
						helper.setTo(emailM.getTo());
						helper.setSubject(emailM.getSubject());
						helper.setText(emailM.getText(), true);
						helper.addAttachment(emailM.getFile().getName(), emailM.getFile());
						mailSender.send(message);
					} catch (MailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (javax.mail.MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
}
}


