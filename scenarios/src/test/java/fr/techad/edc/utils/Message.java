package fr.techad.edc.utils;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	private String id;

	private String subject;

	@JsonProperty("from_email")
	private String fromEmail;

	@JsonProperty("to_email")
	private String toEmail;

	@JsonProperty("html_body")
	public String html;

	@JsonProperty("text_body")
	public String text;

	public Message() {
	}

	public String getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public String getToEmail() {
		return toEmail;
	}

	public String getHtml() {
		return html;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", subject=" + subject + ", fromEmail=" + fromEmail + ", toEmail=" + toEmail + "]";
	}
}
