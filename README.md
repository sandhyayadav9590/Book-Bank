

---

# Book Bank

Book Bank is a Spring Boot application designed to help manage book records in a bookstore. This project implements a CRUD (Create, Read, Update, Delete) functionality using a MySQL database and exposes a REST API for managing book inventory.

## Features

- **CRUD Operations**: Add, update, view, and delete book records.
- **RESTful API**: Exposes endpoints for integration with other applications or clients.
- **MySQL Database**: Stores book information persistently.

## Technologies Used

- **Java** (JDK 11+)
- **Spring Boot** - Backend framework
- **Spring Data JPA** - For data access and ORM
- **MySQL** - Database to store book information
- **Maven** - Build and dependency management

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or above
- MySQL Server
- Maven

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/sandhyayadav9590/BookBank.git
   cd BookBank
   ```

2. **Configure MySQL Database**

   - Create a MySQL database for the application. For example:

     ```sql
     CREATE DATABASE bookbank;
     ```

   - Update the database configuration in `src/main/resources/application.properties`:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/********
     spring.datasource.username=***********
     spring.datasource.password=************
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build and Run the Application**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   The application will start running at [http://localhost:8080](http://localhost:8080).

## API Endpoints

| Method | Endpoint       | Description               |
|--------|----------------|---------------------------|
| GET    | `/getallbooks`   | Retrieve all book records |
| GET    | `/getbookbyid/{id}` | Retrieve a book by ID  |
| POST   | `/addbook`   | Add a new book record     |
| PUT    | `/updatebook/{id}` | Update a book record  |
| DELETE | `/deletebook/{id}` | Delete a book record  |

Each endpoint uses JSON format for request and response bodies.

### Example JSON for creating a book

```json
{
  "title": "Effective Java",
  "price": 45.00,
  
}
```

## Running Tests

Run the following command to execute unit and integration tests:

```bash
mvn test
```

## Contributing

Contributions are welcome! Please fork this repository and submit a pull request with your proposed changes.



--- 

This README provides a clear and straightforward overview of the project. You can expand it by adding more sections, such as "Known Issues," "Future Improvements," or "FAQs" as your project evolves.
