package com.nsbm.ebookstore.book_service.controller;

import com.nsbm.ebookstore.book_service.model.BookModel;
import com.nsbm.ebookstore.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    //Retrieve all books
    @GetMapping("/getAll")
    public List<BookModel> getAllBooks(){
        return bookService.getAllBooks();
    }

    //add book
    @PostMapping("/add")
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel){
        BookModel addedBook = bookService.addBook(bookModel);
        return ResponseEntity.ok(addedBook);
    }

    //update Book
    @PutMapping("/update/{id}")
    public ResponseEntity<BookModel> updateBook(
            @PathVariable("id") Long id,
            @RequestBody BookModel updateRequest
    ) {
        BookModel updatedBook = bookService.updateBook(
                id,
                updateRequest.getIsbn(),
                updateRequest.getBookName(),
                updateRequest.getBookAuthor(),
                updateRequest.getPublisher(),
                updateRequest.getAddedOn(),
                updateRequest.getQuantity()
        );
        return ResponseEntity.ok(updatedBook);
    }

    //delete book
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Deleted book successfully");
    }
}
