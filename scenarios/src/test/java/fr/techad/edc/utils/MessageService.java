package fr.techad.edc.utils;

import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

public class MessageService {

	private String mode;
	public final String baseUrl = "https://mailtrap.io";
	private final String inboxUrl = "/api/v1/inboxes/{inbox_id}"; 
	private final String messagesUrl = "/api/v1/inboxes/{inbox_id}/messages";

	public MessageService() {
	}

	public void setMode(String mode) {
		mode = mode.toLowerCase();
		this.mode = mode;
	}
	
	private Builder configure(String url) {
		Client client = ClientBuilder.newClient().register(JacksonFeature.class);
		WebTarget webTarget = client.target(baseUrl + url).queryParam("api_token", Mailtrap.API_TOKEN);
		return webTarget.request(MediaType.APPLICATION_JSON_TYPE);
	}

	public javax.mail.Message getMessage() throws MessagingException {
		if (mode.equals("pop3"))
			return getPop3Messages();
		else
			return (javax.mail.Message) getMockMessage(getInbox(Mailtrap.INBOX));
			
	}
	
	private Inbox getInbox(String inboxId) {
		String url = inboxUrl.replace("{inbox_id}", inboxId);
		Inbox inbox = configure(url).get(Inbox.class);
		return inbox;
	}

	private List<Message> getMockMessage(Inbox inbox) {
		String url = messagesUrl.replace("{inbox_id}", inbox.getId());
		List<Message> msgs = configure(url).get(new GenericType<List<Message>>() {
		});
		return msgs;
	}

	@SuppressWarnings("unlikely-arg-type")
	private javax.mail.Message getPop3Messages() throws MessagingException {
		getPop3Inbox();
		javax.mail.Message[] msgs = getPop3Inbox().getMessages();

		for (int i = 0; i < msgs.length; i++) {
			if (msgs[i].getFrom().equals("noreply@easydoccontents.com")
					&& msgs[i].getSubject().equals("Welcome to edc! Please activate your account."))
				return msgs[i];
		}
		return null;
	}

	private Folder getPop3Inbox() throws MessagingException {
		Properties properties = System.getProperties();
		Session session = Session.getDefaultInstance(properties);
		Store store = session.getStore("pop3");
		store.connect(Pop3.HOST, Pop3.USERNAME, Pop3.PWD);
		Folder inbox = store.getFolder("Inbox");
		inbox.open(Folder.READ_ONLY);
		return inbox;
	}
}
