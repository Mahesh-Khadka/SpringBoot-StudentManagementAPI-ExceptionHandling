This is a Student Management API built with Spring Boot,
where I gained hands-on experience with exception handling.

I wrote custom exceptions like StudentNotFoundException and 
InvalidStudentDataException to handle domain-specific errors.

These exceptions are caught by a Global Exception Handler 
(@RestControllerAdvice), which returns a structured error
response using the ErrorResponse model containing status, message, and timestamp.

I also practiced mapping between DTOs and entities using ModelMapper,
which simplifies converting request/response objects to database entities and vice versa.

Overall, the project helped me understand layered architecture 
(Controller → Service → Repository → Entity → Exception), validation, 
and consistent API error responses.