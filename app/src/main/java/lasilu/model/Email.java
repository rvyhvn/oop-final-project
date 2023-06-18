package com.project.model;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String subject;
    private String body;
    private List<String> recipients;
    private String attachmentPath;

    public Email(String subject, String body, List<String> recipients, String attachmentPath) {
        this.subject = subject;
        this.body = body;
        this.recipients = recipients;
        this.attachmentPath = attachmentPath;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }
}
