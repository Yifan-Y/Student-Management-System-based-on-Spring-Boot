# Student Management System based on Spring Boot

This is a Java-based web application developed using Spring Boot, Maven, and SQL. The application is designed to manage students, courses, and departments in an educational institution.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- Maven
- SQL database
- An IDE that supports Spring Boot (like IntelliJ IDEA)

### Installing

1. Clone the repository
```
git clone https://github.com/Yifan-Y/StudentMngt.git
```
2. Navigate to the project directory
```
cd StudentMngt
```
3. Build the project
```
mvn clean install
```
4. Run the application
```
mvn spring-boot:run
```

## Running the tests

To run the unit tests, use the following command:

```
mvn test
```

## Application Structure

The application is structured into three main layers:

- **Entity Layer**: This layer contains the `Student`, `Course`, `Department`, `Course`, and `Program` entities. These entities are mapped to the SQL database using JPA annotations.

![Entity Class Diagram](https://github.com/Yifan-Y/Student-Management-System-based-on-Spring-Boot/assets/36191021/23a66689-c9c3-4c6a-b824-4b6b1cde6fa6)

- **DAO Layer**: This layer contains the `StudentRepository`, `CourseRepository`, `DepartmentRepository`, `CourseRepository`, and `ProgramRepository` interfaces. These interfaces extend Spring Data JPA's `JpaRepository` to provide CRUD operations on the entities.

- **Service Layer**: This layer contains the `StudentService`, `CourseService`, `DepartmentService`, `CourseService`, and `ProgramRepository` interfaces and their implementations. These services use the DAOs to interact with the database.

- **Controller Layer**: This layer contains the `StudentController`, `CourseController`, `DepartmentController`, `CourseController`, and `ProgramController` controllers based on Restful API. These classes are responsible for handling HTTP requests.

## Built With

- [Java](https://www.java.com/) - The programming language used
- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Spring Security](https://spring.io/projects/spring-security) - Basic user authentication mechanism
- [Maven](https://maven.apache.org/) - Dependency Management
- [MySQL](https://www.mysql.com/) - Used for data persistence
- [RESTful api](https://www.redhat.com/en/topics/api/what-is-a-rest-api) - Used for handling HTTP requests
- [JUnit](https://junit.org/) - Used for unit test
- [Thymeleaf](https://www.thymeleaf.org/) - The modern server-side Java template engine for both web and standalone environments.
- [Docker Compose](https://docs.docker.com/compose/) - Used for defining and running multi-container applications.
- [AWS Elastic Beanstalk](https://docs.aws.amazon.com/en_us/elastic-beanstalk/) - The cloud service for deploying and scaling web applications


## Author

- **[Yifan-Y](https://github.com/Yifan-Y)** - Initial work

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc.
