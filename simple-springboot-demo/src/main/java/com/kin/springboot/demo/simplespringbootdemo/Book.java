package com.kin.springboot.demo.simplespringbootdemo;

public class Book {
    long id;
    String Title;
    String Author;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public Book(long id, String title, String author) {
        this.id = id;
        Title = title;
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
