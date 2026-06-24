package gov.justucuman.notifications.infraestrucutre.input.rabbitmq;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeCreatedEventPayload {
    private String id;
    private String legajo;
    @JsonProperty("entry_date")
    private String entryDate;
    private String email;
    private String name;
    private String lastname;
}
