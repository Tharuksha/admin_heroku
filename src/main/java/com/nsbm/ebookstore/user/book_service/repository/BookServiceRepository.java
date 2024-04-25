package com.nsbm.ebookstore.user.book_service.repository;

import com.nsbm.ebookstore.user.book_service.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookServiceRepository extends JpaRepository<BookModel, Long> {
}
