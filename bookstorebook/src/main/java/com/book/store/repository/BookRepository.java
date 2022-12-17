package com.book.store.repository;

import org.springframework.stereotype.Repository;

import com.book.store.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book , Integer> , IBookCustomRepository {
	

}
