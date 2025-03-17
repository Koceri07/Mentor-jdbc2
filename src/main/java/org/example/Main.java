package org.example;

import DataBase.DataConfig;
import repo.AuthorRepository;
import repo.BookReposity;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = DataConfig.getConnection();

        if (connection == null || connection.isClosed()){
            throw new SQLException("Connection Promlem");
        }

//        System.out.println(AuthorRepository.getAuthorById(connection, 3));

//        System.out.println(BookReposity.getBookById(connection, 2));
//        BookReposity.creatBookTable(connection);

//        BookReposity.createBook(connection);
//        AuthorRepository.createAuthor(connection);
//        AuthorRepository.createAuthor(connection);

//        BookReposity.updateBookName(connection,1);

        System.out.println(BookReposity.findBooksWithYear(connection, 2000, 1950));
    }
}