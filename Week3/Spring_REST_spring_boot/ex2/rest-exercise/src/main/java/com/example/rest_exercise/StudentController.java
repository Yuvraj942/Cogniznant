package com.example.rest_exercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

// @RestController marks this class as a request handler and automatically 
// serializes returned objects into JSON using Jackson.
@RestController
public class StudentController {

    // 1. Basic GET request returning an Array/List
    @GetMapping("/students")
    public List<String> getAllStudents() {
        return Arrays.asList("Alice", "Bob", "Charlie");
    }

    // 2. GET request with a @PathVariable (Data embedded in the URL path)
    // Example: /students/123
    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable int id) {
        return "Returning details for student ID: " + id;
    }

    // 3. GET request with a @RequestParam (Data passed as a query string)
    // Example: /students/search?name=Alice
    @GetMapping("/students/search")
    public String searchStudent(@RequestParam String name) {
        return "Searching database for student: " + name;
    }
}