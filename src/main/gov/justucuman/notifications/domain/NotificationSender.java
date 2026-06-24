package gov.justucuman.notifications.domain;

public interface NotificationSender {
    void sendWelcomeMail(EmailNotification emailNotification);
}
