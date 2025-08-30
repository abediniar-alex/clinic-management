## Psychological Clinic Management System

Psychological Clinic Management System is a multi-module microservice-ready application.
This project has the following modules:
 

| Modul             | Description                |
| ----------------- | -------------------------- |
| **Core**          | Shared functionalities     |
| **User**          | User and staff management  |
| **Therapy**       | Therapy sessions           |
| **Appointement**  | Appointments management    |
| **Billing**       | Billing and payments       |
| **Notification**  | Notification and messaging |
| **eureka-server** | Microservice               |
| Api               | Api gateway                |

The main development effort has done on user service, core, eureka server and other modules just bootstrapped and are not ready for use.
User service includes endpoints for therapists and specializations.

You can explore end points by following URI:
http\://localhost:8081/swagger-ui/index.html

Minimal security is implemented in the user service, and you can log in with user: admin and password: 123456 credentials.
Currently, I have coded a User module, and you can run the project in the following order:

First run eureka server

Then run user service
