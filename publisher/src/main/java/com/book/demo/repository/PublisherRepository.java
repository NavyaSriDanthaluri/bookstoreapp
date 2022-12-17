package com.book.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.demo.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>, IPublisherCustomRepository {

}
