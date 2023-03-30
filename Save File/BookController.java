package com.ptit.ltw.quanlythuvien.booktest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookTestController {
    @GetMapping("/books")
    public String getBooks(Model model) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        List<BookModel> result = new ArrayList<BookModel>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
                    "root", "");
            statement = connection.createStatement();
            resultset = statement.executeQuery("select * from book");
            while (resultset.next()) {
                int bookcode = resultset.getInt("bookcode");
                String title = resultset.getString("title");
                String author = resultset.getString("author");
                String category = resultset.getString("category");
                boolean approved = resultset.getBoolean("approved");
                result.add(new BookModel(bookcode, title, author, category, approved));
            }
            model.addAttribute("books", result);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "books";
    }

    @GetMapping("/view/{bookcode}")
    public String viewBook(Model model, @PathVariable String bookcode) {
        model.addAttribute("bookcode", bookcode);
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        BookModel book = new BookModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
                    "root", "");
            ps = connection.prepareStatement("select * from book where bookcode=?");

            ps.setInt(1, Integer.valueOf(bookcode));
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                book.setBookcode(resultSet.getInt("bookcode"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategory(resultSet.getString("category"));
                book.setApproved(resultSet.getBoolean("approved"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("book", book);

        return "book-detail";
    }

    @GetMapping("/delete/{bookcode}")
    public String deleteBook(@PathVariable("bookcode") String bookcode) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo",
                    "root", "");
            preparedStatement = connection.prepareStatement("delete from book where bookcode=?");

            preparedStatement.setInt(1, Integer.valueOf(bookcode));
            row = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/books";
    }
}
