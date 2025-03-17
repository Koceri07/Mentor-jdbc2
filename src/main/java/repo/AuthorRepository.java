package repo;

import DataBase.Queries;
import dao.AuthorEntity;
import dao.BookEntity;

import java.awt.desktop.QuitResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorRepository {

    public static void createAuthorTable(Connection connection) throws SQLException {
        String query = Queries.CREAT_AUTHOR_TABLE.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        System.out.println("Table Created Successfully");
    }

    public static void createAuthor(Connection connection) throws SQLException {
        String query = Queries.INSERT_AUTHOR.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        String authorFirstName = inputString("New Author FirstName:");
        String authorLastName = inputString("New Author Last Name");
        int authorAge = inputInt("New Author Age");

        preparedStatement.setString(1,authorFirstName);
        preparedStatement.setString(2,authorLastName);
        preparedStatement.setInt(3,authorAge);

        boolean resultSet = preparedStatement.execute();

        if (resultSet) System.out.println("Author Insert Successfully");
        else System.out.println("Have a Problem");
    }

    public static List<AuthorEntity> getAllAuthors(Connection connection) throws SQLException {
        String query = Queries.INSERT_AUTHOR.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<AuthorEntity> authors = new ArrayList<>();

        while (resultSet.next()){
            AuthorEntity author = new AuthorEntity();

            author.setFirstName(resultSet.getString("fist_name"));
            author.setLastName(resultSet.getString("last_name"));
            author.setAge(resultSet.getInt("age"));

            authors.add(author);
        }
        return authors;
    }

    public static AuthorEntity getAuthorById(Connection connection, int id) throws SQLException {
        String query = Queries.FIND_AUTHOR_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()){
            //Set Author
            AuthorEntity author = new AuthorEntity();

            author.setFirstName(resultSet.getString("first_name"));
            author.setLastName(resultSet.getString("last_name"));
            author.setAge(resultSet.getInt("age"));


            //Find Book`s Info
            String bookQuery = Queries.FIND_BOOK_NAME_BY_AUTHOR_ID.getQuery();
            PreparedStatement bookPreparedStatement = connection.prepareStatement(bookQuery);
            bookPreparedStatement.setInt(1,id);
            ResultSet bookResult = bookPreparedStatement.executeQuery();

            //Set Book
            List<BookEntity> authorsBooks = new ArrayList<>();
            while (bookResult.next()) {
                BookEntity book = new BookEntity();
                book.setBookName(bookResult.getString("book_name"));
                book.setYear(bookResult.getInt("year"));
                book.setBookAuthorName(bookResult.getString("book_author_name"));
                authorsBooks.add(book);
            }
            author.setBooksName(authorsBooks);
            return author;
        }
        return null;
    }


    public static void updeteAuthorFirstName(Connection connection,int id) throws SQLException {
        String query = Queries.UPDATE_AUTHOR_FIRST_NAME.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        String newAuthorFirstName = inputString("Insert New Author Name");

        preparedStatement.setString(1,newAuthorFirstName);
        preparedStatement.setInt(2,id);

        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id Not Found");
        else System.out.println("Author Updated Successfully");
    }

    public static void updateAuthorLastName(Connection connection, int id) throws SQLException {
        String query = Queries.UPDATE_AUTHOR_LAST_NAME.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        String newAuthorLastName = inputString("Insert New Auothor Last Name");

        preparedStatement.setString(1,newAuthorLastName);
        preparedStatement.setInt(2,id);

        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id Not Found");
        else System.out.println("Author Updated Successfully");
    }

    public static void updateAuthorAgeName(Connection connection, int id) throws SQLException {
        String query = Queries.UPDATE_AUTHOR_AGE.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        int newAuthorAge = inputInt("Insert New Author Age");

        preparedStatement.setInt(1,newAuthorAge);
        preparedStatement.setInt(2,id);

        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id Not Found");
        else System.out.println("Author Update Successfully");
    }

    public static void deleteAuthotById(Connection connection,int id) throws SQLException {
        String query = Queries.DELETE_AUTHOR_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);

        int resultSet = preparedStatement.executeUpdate();

        if (resultSet == 0) System.out.println("Id not Found");
        else System.out.println("Successfully Deleted");
    }

    public static String inputString(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }
    public static int inputInt(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }
}
