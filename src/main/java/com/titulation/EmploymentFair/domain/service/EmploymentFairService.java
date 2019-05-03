package com.titulation.EmploymentFair.domain.service;

import com.titulation.EmploymentFair.domain.model.EmploymentFair;
import com.titulation.EmploymentFair.domain.repository.EmploymentFairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmploymentFairService {
    
    private EmploymentFairRepository employmentFairRepository;

    @Autowired
    public EmploymentFairService(EmploymentFairRepository employmentFairService) {
        this.employmentFairRepository = employmentFairService;
    }
    
    public EmploymentFair getEmploymentFairs(int idEvent) {
        try{
            return employmentFairRepository.findByIdEvento(idEvent).get(0);
        }catch(Exception ex) {
            return null;
        }
    }
    
    public EmploymentFair saveEmploymentFair(EmploymentFair employmentFair) {
        return employmentFairRepository.save(employmentFair);
    }
    
}
