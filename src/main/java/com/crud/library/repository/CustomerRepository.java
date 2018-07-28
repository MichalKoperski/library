package com.crud.library.repository;

import com.crud.library.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer save(Customer customer);
}
