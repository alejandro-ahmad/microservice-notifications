package gov.justucuman.notifications.infraestrucutre.input.rabbitmq;

import gov.justucuman.notifications.application.SendWelcomeUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class EmployeeCreatedListener {

    private final ObjectMapper objectMapper;
    private final SendWelcomeUseCase useCase;

    public EmployeeCreatedListener(ObjectMapper objectMapper, SendWelcomeUseCase useCase) {
        this.objectMapper = objectMapper;
        this.useCase = useCase;
    }

    @RabbitListener(queues = RabbitMqNotificationConfig.QUEUE_NAME)
    public void handleEmployeeCreated(String messageJson) {
        try {
            EmployeeCreatedEventPayload payload = objectMapper.readValue(messageJson, EmployeeCreatedEventPayload.class);

            useCase.execute(payload.getEmail(), payload.getLegajo(), payload.getEntryDate(),payload.getName(),payload.getLastname());

        } catch (Exception e) {
            System.err.println("❌ Falló la conversión interna del JSON: " + e.getMessage());
        }
    }
}
