package fr.techad.edc.utils;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inbox {

	private String id;
	private String name;

	@JsonProperty("emails_count")
	private int emailsCount;

	@JsonProperty("emails_unread_count")
	private int emailsUnreadCount;

	public Inbox() {
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getEmailsCount() {
		return emailsCount;
	}

	public int getEmailsUnreadCount() {
		return emailsUnreadCount;
	}

	@Override
	public String toString() {
		return "Inbox [id=" + id + ", name=" + name + ", emailsCount=" + emailsCount + ", emailsUnreadCount="
				+ emailsUnreadCount + "]";
	}

}
