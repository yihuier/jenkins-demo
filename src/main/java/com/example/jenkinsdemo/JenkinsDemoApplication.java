package com.example.jenkinsdemo;

import com.example.jenkinsdemo.entity.Test;
import com.example.jenkinsdemo.repository.TestRepository;
import com.example.jenkinsdemo.web.CreateRequest;
import com.example.jenkinsdemo.web.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RestController
public class JenkinsDemoApplication {
    @Autowired
    TestRepository testRepository;

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDemoApplication.class, args);
    }

    @RequestMapping("/demo")
    public GetResponse get() {
        List<Test> tests = testRepository.findAll();
        GetResponse response = new GetResponse();
        if (tests.isEmpty()) {
            return response;
        }
        response.setDescription(tests.get(0).getDescription());
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/demo")
    public void create(@RequestBody CreateRequest request) {
        Test test = new Test();
        test.setId(UUID.randomUUID().toString());
        test.setDescription(request.getDescription());
        testRepository.save(test);
    }
}
