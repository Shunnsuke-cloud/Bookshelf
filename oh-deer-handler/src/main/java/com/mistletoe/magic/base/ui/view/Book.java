package com.mistletoe.magic.base.ui.view;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private LocalDate purchaseDate;

    public Book(String title, String author, LocalDate purchaseDate){
        this.title=title;
        this.author=author;
        this.purchaseDate=purchaseDate;
    }
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public LocalDate getPurchaseDate() {return purchaseDate; }
    
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    
}
