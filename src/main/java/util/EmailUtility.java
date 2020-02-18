package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class EmailUtility {
	// for example, smtp.mailgun.org
	private static final String SMTP_SERVER = "smtp.gmail.com";
	private static final String USERNAME = "mostafa.s.elgazzar@gmail.com";
	private static final String PASSWORD = "P@$$";

	private static final String EMAIL_FROM = "mostafa.s.elgazzar@gmail.com";
	private static final String EMAIL_TO = "mostafasaead@gmail.com";
	private static final String EMAIL_TO_CC = "";

	private static final String EMAIL_SUBJECT = "Test Send Email via SMTP";
	private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";

	public static void sendEmail() {

		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", SMTP_SERVER); // optional, defined in SMTPTransport
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587"); // default port 25
		prop.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(prop, null);
		Message msg = new MimeMessage(session);

		try {

			// from
			msg.setFrom(new InternetAddress(EMAIL_FROM));

			// to
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO, false));

			// cc
			msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(EMAIL_TO_CC, false));

			// subject
			msg.setSubject(EMAIL_SUBJECT);

			// content
			msg.setText(EMAIL_TEXT);

			msg.setSentDate(new Date());

			// Get SMTPTransport
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

			// connect
			t.connect(SMTP_SERVER, USERNAME, PASSWORD);

			// send
			t.sendMessage(msg, msg.getAllRecipients());

			System.out.println("Response: " + t.getLastServerResponse());

			t.close();

		} catch (MessagingException e) {
			System.err.println(
					"something went worng while trying to send email, please make sure from your username and password");
		}

	}

}
