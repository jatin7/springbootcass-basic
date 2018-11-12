package com.ymeng.mybookrating.repository;

import com.ymeng.mybookrating.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CassandraRepository<Book, Long> {

}
