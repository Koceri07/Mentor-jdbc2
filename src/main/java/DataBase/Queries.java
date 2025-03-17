package DataBase;

public enum Queries {

    //Book`s Queries:
    CREAT_BOOK_TABLE("CREATE TABLE IF NOT EXISTS books(\n" +
            "    id SERIAL PRIMARY KEY,\n" +
            "    book_name VARCHAR(50)NOT NULL,\n" +
            "    book_author_name VARCHAR(50) NOT NULL ,\n" +
            "    year INTEGER NOT NULL\n" +
            "    book_author_id INTEGER NOT NULL\n" +
            ");"),

    FIND_ALL_BOOKS("SELECT * FROM books;"),
    FIND_BOOK_BY_ID("SELECT * FROM books b JOIN public.authors a on b.author_id = a.id WHERE b.id = ? ORDER BY b.year DESC;"),
    INSERT_BOOK("INSERT INTO books(book_name, book_author_name, year,author_id) VALUES (?,?,?,?);"),
    UPDATE_BOOK_NAME("UPDATE books SET book_name = ? WHERE id = ?;"),
    UPDATE_BOOK_AUTHOR_NAME("UPDATE books SET book_author_name = ? WHERE id = ?;"),
    UPDATE_BOOK_YEAR("UPDATE books SET year = ? WHERE id = ?;"),
    DELETE_BOOK_BY_ID("DELETE FROM books WHERE id = ?;"),


    //Author`s Queries:
    CREAT_AUTHOR_TABLE("CREATE TABLE IF NOT EXISTS authors(\n" +
                                 "    id SERIAL PRIMARY KEY,\n" +
                                 "    first_name VARCHAR(50)NOT NULL,\n" +
                                 "    last_name VARCHAR(50) NOT NULL ,\n" +
                                 "    age INTEGER NOT NULL\n" +
                                 "    book_id INTEGER NOT NULL\n" +
                                 ");"),

    FIND_ALL_AUTHOR("SELECT * FROM authors;"),
    FIND_AUTHOR_BY_ID("SELECT * FROM authors a JOIN books b ON b.author_id = a.id WHERE a.id = ? ORDER BY b.year DESC;"),
    INSERT_AUTHOR("INSERT INTO authors(first_name, last_name, age) VALUES (?,?,?);"),
    UPDATE_AUTHOR_FIRST_NAME("UPDATE authors SET first_name = ? WHERE id = ?;"),
    UPDATE_AUTHOR_LAST_NAME("UPDATE authors SET last_name = ? WHERE id = ?;"),
    UPDATE_AUTHOR_AGE("UPDATE authors SET age = ? WHERE id = ?;"),
    DELETE_AUTHOR_BY_ID("DELETE FROM authors WHERE id = ?;"),

//

    FIND_BOOKS_WITH_YEAR("SELECT * FROM books WHERE year > ? AND id < ?;"),
    FIND_BOOK_NAME_BY_AUTHOR_ID("SELECT * FROM books WHERE author_id = ?;");



    private String query;

    Queries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
