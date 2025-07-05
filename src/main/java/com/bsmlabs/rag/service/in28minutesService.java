package com.bsmlabs.rag.service;

import com.bsmlabs.rag.model.In28minutesCourses;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class in28minutesService {

    private static final Logger log = LoggerFactory.getLogger(in28minutesService.class);
    private final List<In28minutesCourses>  in28minutesCourses = new ArrayList<>();

    /**
     * @Tool: Transforms regular methods into MCP-compatible tools and each tool has a unique name and descriptive text to help AI models understand its purpose
     * Parameters become tool arguments that can be passed by the AI model
     * @return The data returned is automatically serialized into a format the AI model can understand
     */
    @Tool(name ="in28minutes_get_courses", description = "Get a list of courses from in28minutes")
    public List<In28minutesCourses> getIn28minutesCourses() {
        return in28minutesCourses;
    }

    /**
     * @Tool: Transforms regular methods into MCP-compatible tools and each tool has a unique name and descriptive text to help AI models understand its purpose
     * Parameters become tool arguments that can be passed by the AI model
     * @return The data returned is automatically serialized into a format the AI model can understand
     */
    @Tool(name ="in28minutes_get_course", description = "Get a single course from in28minutes by title")
    public In28minutesCourses getIn28minutesCourse(String title, String url) {
        return in28minutesCourses.stream()
                .filter(course -> course.title().equals(title))
                .findFirst()
                .orElse(null);
    }

    @PostConstruct
    public void init() {
        in28minutesCourses.addAll(List.of(
                new In28minutesCourses("Java Programming for Complete Beginners",
                        "https://www.udemy.com/course/java-programming-tutorial-for-beginners"),
                new In28minutesCourses("Master Spring Boot 3 & Spring Framework 6 with Java",
                        "https://www.udemy.com/course/spring-boot-and-spring-framework-tutorial-for-beginners"),
                new In28minutesCourses("Master Microservices with Spring Boot and Spring Cloud",
                        "https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud")
        ));
    }

}
