package gov.justucuman.notifications.infraestrucutre.output.email;

import gov.justucuman.notifications.domain.EmailNotification;
import gov.justucuman.notifications.domain.NotificationSender;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class JavaMailNotificationSender implements NotificationSender {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public JavaMailNotificationSender(JavaMailSender sender,TemplateEngine engine){
        this.mailSender = sender;
        this.templateEngine = engine;
    }

    @Override
    public void sendWelcomeMail(EmailNotification notification){
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");

            Context context = new Context();
            context.setVariable("name",notification.name());
            context.setVariable("lastname",notification.lastname());
            context.setVariable("legajo",notification.legajo());
            context.setVariable("entryDate",notification.entryDate());

            String htmlContent = templateEngine.process("welcome-mail",context);

            helper.setTo(notification.to());
            helper.setSubject(notification.subject());
            helper.setText(htmlContent,true);
            helper.setFrom("no-reply@justucuman.gov.ar");

            mailSender.send(mimeMessage);

            System.out.println("📬 ¡Email corporativo HTML enviado con éxito a: " + notification.to());
        }catch (Exception e){
            throw new RuntimeException("Error critico al renderizar o enviar el correo");
        }
    }
}
