package com.crud.library.repository;

import com.crud.library.domain.CopyOfBook;
import com.crud.library.domain.Customer;
import com.crud.library.domain.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Integer> {

    Rent save (Rent rent);

    void deleteById (long id);
}
