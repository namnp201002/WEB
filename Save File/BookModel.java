package com.ptit.ltw.quanlythuvien.booktest;

public class BookModel {
    private int bookcode;
    private String title;
    private String author;
    private String category;
    private boolean approved;

    public int getBookcode() {
        return bookcode;
    }

    public void setBookcode(int bookcode) {
        this.bookcode = bookcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public BookModel(int bookcode, String title, String author, String category, boolean approved) {
        this.bookcode = bookcode;
        this.title = title;
        this.author = author;
        this.category = category;
        this.approved = approved;
    }

    public BookModel() {
    }
}
