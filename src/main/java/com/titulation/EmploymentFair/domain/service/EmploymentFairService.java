package com.titulation.EmploymentFair.domain.service;

import com.titulation.EmploymentFair.domain.model.EmploymentFair;
import com.titulation.EmploymentFair.domain.repository.EmploymentFairRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmploymentFairService {
    
    private EmploymentFairRepository employmentFairRepository;

    @Autowired
    public EmploymentFairService(EmploymentFairRepository employmentFairService) {
        this.employmentFairRepository = employmentFairService;
    }
    
    public List<EmploymentFair> getEmploymentFairs(int idEvent) {
        return employmentFairRepository.findByIdEvento(idEvent);
    }
    
    public EmploymentFair saveEmploymentFair(EmploymentFair employmentFair) {
        return employmentFairRepository.save(employmentFair);
    }
    
}
