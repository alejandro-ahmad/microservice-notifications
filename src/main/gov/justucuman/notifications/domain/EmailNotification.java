package gov.justucuman.notifications.domain;

public final class EmailNotification {
    private final String to;
    private final String subject;
    private final String legajo;
    private final String entryDate;
    private final String name;
    private final String lastname;

    public EmailNotification(String to,String subject,String legajo, String entryDate,String name,String lastname){
        this.to = to;
        this.subject = subject;
        this.legajo = legajo;
        this.entryDate = entryDate;
        this.name = name;
        this.lastname = lastname;
    }

    public String to(){return to;}
    public String subject(){return subject;}
    public String legajo(){return legajo;}
    public String entryDate(){return entryDate;}
    public String name(){return name;}
    public String lastname(){return lastname;}
}
