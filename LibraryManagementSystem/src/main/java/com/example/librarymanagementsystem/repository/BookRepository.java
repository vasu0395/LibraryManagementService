package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
}
