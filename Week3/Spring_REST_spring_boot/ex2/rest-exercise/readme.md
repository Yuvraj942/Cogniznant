REST API and HTTP Fundamentals Exercise

This repository demonstrates the core concepts of HTTP requests, RESTful Web Services, and automated testing using Spring's MockMvc.

1. HTTP Request and Response

HTTP (Hypertext Transfer Protocol) is the foundation of data communication on the World Wide Web. It operates on a client-server model.

HTTP Request Format

When a client (like a browser or Postman) asks for data, it sends a structured request:

Request Line: Contains the Request Method (e.g., GET), the Request URL (e.g., /api/students), and the HTTP version.

Headers: Metadata about the request.

Content-Type: Defines the format of the body (e.g., application/json).

User-Agent: Identifies the client making the request.

Body: Optional. Used in POST or PUT requests to send data to the server.

HTTP Response Format

When the server answers, it sends back:

Status Line: Contains the Status Code (e.g., 200 OK, 404 Not Found).

Headers: Metadata about the response (e.g., informing the client that the body is JSON).

Body: The actual requested data.

2. The Need and Benefits of RESTful Web Services

REST (REpresentational State Transfer) is an architectural style for building web services that leverage the HTTP protocol.

Core Benefits:

Lightweight & Scalable: By using JSON and remaining stateless, servers can handle high loads and scale horizontally.

Maintainable (Client-Server Separation): The frontend and backend are completely decoupled. They interact solely through the API.

Standardized Verbs: Maps CRUD operations directly to HTTP methods:

GET: Read a resource.

POST: Create a resource.

PUT: Update a resource.

DELETE: Remove a resource.

3. Implementing a RESTful Web Service (GET)

This project contains a StudentController that demonstrates returning JSON data via GET requests.

@RestController: A specialized version of @Controller that adds the @ResponseBody annotation automatically. It ensures that returned objects (like a List) are serialized directly into JSON.

@GetMapping: Maps specific HTTP GET requests onto specific handler methods.

Endpoints demonstrated:

/students: Returns a JSON array of student names.

/students/{id}: Demonstrates the use of @PathVariable to extract data directly from the URL structure.

/students/search?name=value: Demonstrates the use of @RequestParam to extract data from query string parameters.

Testing the API

Browser: Navigating to http://localhost:8080/students triggers a basic GET request.

Postman: Allows you to configure specific GET requests, inspect the raw JSON response, and view HTTP status codes (like 200 OK) and headers.

4. End-to-End Testing with MockMVC

Manual testing via Postman is slow. Spring provides MockMvc to simulate HTTP requests and assert responses programmatically without starting a real web server.

@AutoConfigureMockMvc & MockMvc: Sets up the mock environment allowing us to dispatch requests to our controllers.

perform(get(...)): Simulates a specific HTTP request.

Assertions (andExpect):

status().isOk(): Asserts that the HTTP response code is 200.

status().isBadRequest(): Asserts that the HTTP response code is 400 (e.g., when a required parameter is missing).

jsonPath("$").isArray(): Uses JSONPath expressions to verify the structure and content of the returned JSON body.