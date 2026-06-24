package gov.justucuman.notifications.application;

import gov.justucuman.notifications.domain.EmailNotification;
import gov.justucuman.notifications.domain.NotificationSender;
import org.springframework.stereotype.Service;

@Service
public final class SendWelcomeUseCase {
    private final NotificationSender sender;

    public SendWelcomeUseCase(NotificationSender sender){
        this.sender = sender;
    }

    public void execute(String to,String legajo, String entryDate,String name,String lastname){
        String subject = "¡Bienvenido al equipo! 🎉 Tu legajo ya está activo";

        EmailNotification notification = new EmailNotification(to,subject,legajo,entryDate,name,lastname);

        sender.sendWelcomeMail(notification);
    }
}
