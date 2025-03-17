package repo;

import DataBase.Queries;
import dao.BookEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookReposity {

    public static void creatBookTable(Connection connection) throws SQLException {
        String query = Queries.CREAT_BOOK_TABLE.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        System.out.println("Table Create Successfully");
    }

    public static void createBook(Connection connection) throws SQLException {
        String query = Queries.INSERT_BOOK.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        String bookName = inputString("Book Name:");
        String bookAuthorName = inputString("Book Author Name");
        int year = inputInt("Year:");
        int authorId = inputInt("Author Id");

        preparedStatement.setString(1,bookName);
        preparedStatement.setString(2,bookAuthorName);
        preparedStatement.setInt(3,year);
        preparedStatement.setInt(4,authorId);

        int result = preparedStatement.executeUpdate();
        if (result == 1) System.out.println("Successfully Created");
        else System.out.println("Have a Problem");
    }

    public static List<BookEntity> getAllBooks(Connection connection) throws SQLException {
        String query = Queries.FIND_ALL_BOOKS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        List<BookEntity> books = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            BookEntity book = new BookEntity();

            book.setBookName(resultSet.getString("book_name"));
            book.setBookAuthorName(resultSet.getString("book_author_name"));
            book.setYear(resultSet.getInt("year"));

            books.add(book);
        }
        return books;
    }

    public static BookEntity getBookById(Connection connection,int id) throws SQLException {
        String query = Queries.FIND_BOOK_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            BookEntity book = new BookEntity();

            book.setBookName(resultSet.getString("book_name"));
            book.setBookAuthorName(resultSet.getString("book_author_name"));
            book.setYear(resultSet.getInt("year"));
            book.setId(resultSet.getInt("id"));
            book.setBookAuthorId(resultSet.getInt("author_id"));

            return book;
        }
        return null;
    }

    public static void updateBookName(Connection connection, int id) throws SQLException {
        String query = Queries.UPDATE_BOOK_NAME.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        String newBookName = inputString("Insert New Book Name");

        preparedStatement.setString(1 , newBookName);
        preparedStatement.setInt(2 , id);
        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id Not Found");
        else System.out.println("Successfully Update");
    }

    public static void updateBookAuthorName(Connection connection, int id) throws SQLException {
        String query = Queries.UPDATE_BOOK_AUTHOR_NAME.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        String newBookAuthorName = inputString("Insert New Book Author Name:");

        preparedStatement.setString(1, newBookAuthorName);
        preparedStatement.setInt(2,id);

        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id Not Found");
        else System.out.println("Successfully Update");
    }

    public static void updateBookYear(Connection connection, int id) throws SQLException {
        String query = Queries.UPDATE_BOOK_YEAR.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int newBookYear = inputInt("Insert New Book Year");

        preparedStatement.setInt(1,newBookYear);
        preparedStatement.setInt(2,id);

        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id Not Found");
        else System.out.println("Successfully Update");
    }

    public static void deleteBookById(Connection connection, int id) throws SQLException {
        String query = Queries.DELETE_BOOK_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,id);
        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id Not Found");
        else System.out.println("Book Deleted Successfully");
    }

    public static List<BookEntity> findBooksWithYear(Connection connection , int year1, int year2) throws SQLException {
        String qeury = Queries.FIND_BOOKS_WITH_YEAR.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(qeury);
        if (year1 > year2){
            preparedStatement.setInt(1,year2);
            preparedStatement.setInt(2,year1);
        }
        else {
            preparedStatement.setInt(1,year1);
            preparedStatement.setInt(2,year2);
        }


        List<BookEntity> books = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            BookEntity bookEntity = new BookEntity();

            bookEntity.setBookName(resultSet.getString("book_name"));
            bookEntity.setBookAuthorName(resultSet.getString("book_author_name"));
            bookEntity.setYear(resultSet.getInt("year"));
            bookEntity.setId(resultSet.getInt("id"));

            books.add(bookEntity);
        }
        return books;
    }

    public static String  inputString(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

    public static int inputInt(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        return a;
    }
}
