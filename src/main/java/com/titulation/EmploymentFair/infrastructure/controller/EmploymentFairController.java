package com.titulation.EmploymentFair.infrastructure.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.titulation.EmploymentFair.domain.model.EmploymentFair;
import com.titulation.EmploymentFair.domain.service.EmploymentFairService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employment_fair")
public class EmploymentFairController {
    
    private EmploymentFairService employmentFairService;

    @Autowired
    public EmploymentFairController(EmploymentFairService employmentFairService) {
        this.employmentFairService = employmentFairService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<EmploymentFair> getEmploymentFair(@PathVariable("id") int idEvento) {
        EmploymentFair employmentFair = employmentFairService.getEmploymentFairs(idEvento);
        return (employmentFair == null) ? new ResponseEntity<>(employmentFair, NOT_FOUND) : new ResponseEntity<>(employmentFair, OK);
    }
    
    @PostMapping()
    public ResponseEntity<EmploymentFair> saveEmploymentFair(@RequestBody EmploymentFair employmentFair) {
        return new ResponseEntity<>(employmentFairService.saveEmploymentFair(employmentFair), OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/events")
    public ResponseEntity<List<EmploymentFair>> getNextEmploymentFairs () {
        return new ResponseEntity<>(employmentFairService.getNextEvents(), OK);
    }
    
}
