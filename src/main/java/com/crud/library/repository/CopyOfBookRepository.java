package com.crud.library.repository;

import com.crud.library.domain.Book;
import com.crud.library.domain.CopyOfBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface CopyOfBookRepository extends CrudRepository<CopyOfBook, Integer> {

    CopyOfBook save(CopyOfBook copyOfBook);

    List<CopyOfBook> findAll();
}
