package com.nsbm.ebookstore.book_service.service;

import com.nsbm.ebookstore.book_service.model.BookModel;
import com.nsbm.ebookstore.book_service.repository.BookServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookServiceRepository bookServiceRepository;

    //get all the books list
    public List<BookModel> getAllBooks(){
        return bookServiceRepository.findAll();
    }

    //add books
    public BookModel addBook(BookModel bookModel){
        return bookServiceRepository.save(bookModel);
    }

    //delete book
    public void deleteBook(Long id){
        bookServiceRepository.deleteById(id);
    }

    //update book
    public BookModel updateBook(Long id, String isbn, String bookName, String bookAuthor, String publisher, Date addedOn,  int quantity) {
        BookModel bookModel = bookServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id));

        // Set the updated values
        bookModel.setIsbn(isbn);
        bookModel.setBookName(bookName);
        bookModel.setBookAuthor(bookAuthor);
        bookModel.setPublisher(publisher);
        bookModel.setAddedOn(addedOn);
        bookModel.setQuantity(quantity);

        return bookServiceRepository.save(bookModel);
    }
}

