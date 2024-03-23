package com.example.librarymanagementsystem.helpers;

import com.example.librarymanagementsystem.entity.BookEntity;
import com.example.librarymanagementsystem.entity.UserEntity;
import com.example.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookHelper {
    private final BookRepository bookRepository;

    public BookEntity getBookById(Integer bookId){
        BookEntity bookEntity = bookRepository.getById(bookId);
        return bookEntity;
    }
}
