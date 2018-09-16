package fr.techad.edc.utils;

import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

public class ServerService {

	private String strMode;
	private Wiser Wiserserver;
	private Session session;

	/**
	 * set the mode of the server
	 * 
	 * @param strMode
	 */
	public void setMode(String strMode) {
		strMode = strMode.toLowerCase();
		this.strMode = strMode;
	}

	/**
	 * set the server in fonction of the mode slected
	 */
	public void setServer() {
		if (strMode.equals("local")) {
			setLocalServer();
		} else {
			stopLocalServer();
		}
	}

	/**
	 * set the parameters of the server smtp
	 */
	private void setLocalServer() {
		//Properties props = new Properties();
		//props.setProperty("mail.smtp.host", "localhost");
		//props.setProperty("mail.smtp.port", Integer.toString(25));
		//this.session = Session.getInstance(props);
		this.Wiserserver = new Wiser();
		this.Wiserserver.setPort(25);
		this.Wiserserver.start();
	}

	/**
	 * Stop the local server if it is on
	 */
	private void stopLocalServer() {
		this.Wiserserver.stop();
	}

	/**
	 * Send a message throught the wiser server
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendMessage() throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress("from@somewhere.com"));
		message.addRecipient(RecipientType.TO, new InternetAddress("to@somewhere.com"));

		message.setSubject("Hello world!");
		message.setContent("Sent via an SMTP server WISER.", "text/plain");

		Transport.send(message);
	}

	/**
	 * Get all the messages Sent
	 * 
	 * @return
	 */
	public List<WiserMessage> getLocalMessage() {
		return Wiserserver.getMessages();
	}
	
	public Wiser getWiser() {
		return this.Wiserserver;
	}
}
