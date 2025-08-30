## Psychological Clinic Management System

Psychological Clinic Management System is a multi-module microservice ready application.
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

User service contains endpoints for therapists and specializations.

You can explore end points by following URI:
http\://localhost:8081/swagger-ui/index.html

A minimal security implemented in user service and you can login with user: admin and password: 123456 credentials
Currenty I have coded User module and you can run the project with following order:

First run eureka server

Then run user service
