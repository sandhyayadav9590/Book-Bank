package com.example.Book_Bank.Controller;

import com.example.Book_Bank.Modal.Book;
import com.example.Book_Bank.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
 private BookRepo bookRepo;

    @GetMapping("/getallbooks")
    public ResponseEntity<List<Book>> getAllBook()
    {
        try{
            List<Book> bookList = new ArrayList<>();
            bookRepo.findAll().forEach(bookList::add);

            if(bookList.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookList,HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
  @PostMapping("/addbook")
    public String  postBook(@RequestBody Book book)
  {
      bookRepo.save(book);
      return "Book added to database successfully";
  }
  @GetMapping("/getbookbyid/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id)
  {
      Optional<Book> bookdata= bookRepo.findById(id);
      if(bookdata.isPresent())
      {
          return  new ResponseEntity(bookdata.get(),HttpStatus.OK);
      }
      return  new ResponseEntity(HttpStatus.NOT_FOUND);

  }

  @PutMapping("/updatebook/{id}")
  public ResponseEntity<Book> updatebook(@PathVariable Long id,@RequestBody Book newbookdata)
  {
 Optional<Book> oldbook = bookRepo.findById(id);
 if(oldbook.isPresent())
 {
     Book booktobeupdated = oldbook.get();
     booktobeupdated.setTitle(newbookdata.getTitle());
     booktobeupdated.setPrice(newbookdata.getPrice());

     Book updatedbook = bookRepo.save(booktobeupdated);
     return  new ResponseEntity<>(updatedbook,HttpStatus.OK);


 }
 return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }


  @DeleteMapping("/deletebook/{id}")
public  ResponseEntity<Book> deletebookbyid(@PathVariable Long id)
{
    bookRepo.deleteById(id);
    return  new ResponseEntity<>(HttpStatus.OK);
}

}
