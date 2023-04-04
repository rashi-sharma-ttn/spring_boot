package com.jpa.jpa.assignment1.empRepo;

import com.jpa.jpa.assignment1.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface EmpRepository extends CrudRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer> {

    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(int a1, int a2);

}
