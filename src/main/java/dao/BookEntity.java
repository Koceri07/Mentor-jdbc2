package dao;

import java.util.List;
import java.util.Objects;

public class BookEntity {
    private int id;
    private String bookName;
    private int year;
    private String bookAuthorName;
    private int bookAuthorId;
    private List<AuthorEntity> authorEntityList;

    public BookEntity(String bookName, int year, String bookAuthorName, int id, int bookAuthorId) {
        this.id = id;
        this.bookName = bookName;
        this.year = year;
        this.bookAuthorName = bookAuthorName;
        this.bookAuthorId = bookAuthorId;
    }


    public BookEntity() {
    }

    public List<AuthorEntity> getAuthorEntityList() {
        return authorEntityList;
    }

    public void setAuthorEntityList(List<AuthorEntity> authorEntityList) {
        this.authorEntityList = authorEntityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public int getBookAuthorId() {
        return bookAuthorId;
    }

    public void setBookAuthorId(int bookAuthorId) {
        this.bookAuthorId = bookAuthorId;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", year=" + year +
                ", bookAuthorName='" + bookAuthorName + '\'' +
                ", bookAuthorId=" + bookAuthorId +
                ", authorEntityList=" + authorEntityList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
