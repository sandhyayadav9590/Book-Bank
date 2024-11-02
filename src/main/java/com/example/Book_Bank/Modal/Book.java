package com.example.Book_Bank.Modal;


import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book
{   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private String Title;
    private  float price;


    public Book() {
    }

    public Book(Long id, String title, float price) {
        this.id = id;
        Title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
