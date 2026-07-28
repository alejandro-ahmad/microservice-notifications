# ✉️ Notification Microservice

A decoupled microservice responsible for asynchronous processing and email delivery within the HR ecosystem.

---

## 🎯 Purpose

Listens for domain events published by the core application (`rrhh-personal-api`) and dispatches automated transactional emails to new employees, containing their **employee ID/file number** and **official start date**.

---

## 🛠️ Tech Stack

* **Language & Framework:** Java 21 / Spring Boot
* **Messaging:** Apache Kafka / RabbitMQ
* **Integration:** Spring Mail / SMTP Server

---

## 📩 Consumed Events

### `EmployeeCreatedEvent`
Listens to the event emitted after an employee is created and processes the welcome email template with the following required fields:
* Employee full name
* Recipient email address
* Assigned employee ID / file number
* Start date

---

## 🚀 Local Execution

```bash
# Clone the repository
git clone [https://github.com/alejandro-ahmad/microservice-notifications.git](https://github.com/alejandro-ahmad/microservice-notifications.git)

# Run the application
./gradlew bootRun
