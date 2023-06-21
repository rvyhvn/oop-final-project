package lasilu.model;

import java.util.List;

public class Email {
    private String EMAIL_SENDER; // Ganti properti 'from' menjadi 'EMAIL_SENDER'
    private String subject;
    private String body;
    private List<String> recipients;
    private String attachmentPath;

    public Email() {

    }

    public Email(String EMAIL_SENDER, String subject, String body, List<String> recipients, String attachmentPath) {
        this.EMAIL_SENDER = EMAIL_SENDER;
        this.subject = subject;
        this.body = body;
        this.recipients = recipients;
        this.attachmentPath = attachmentPath;
    }

    public String getEMAIL_SENDER() {
        return EMAIL_SENDER;
    }

    public void setEMAIL_SENDER(String EMAIL_SENDER) {
        this.EMAIL_SENDER = EMAIL_SENDER;
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