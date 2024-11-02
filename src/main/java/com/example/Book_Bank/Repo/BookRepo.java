package com.example.Book_Bank.Repo;

import com.example.Book_Bank.Modal.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
