package com.titulation.EmploymentFair.domain.repository;

import com.titulation.EmploymentFair.domain.model.EmploymentFair;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentFairRepository extends CrudRepository<EmploymentFair, Integer> {
    
    public List<EmploymentFair> findByIdEvento(int idEvento);
    
}
