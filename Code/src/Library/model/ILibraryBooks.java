package Library.model;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ILibraryBooks
{
    void addBook(Book book) throws IOException;
    void borrowBook(Book book) throws FileNotFoundException;
    void returnBook(Book book) throws FileNotFoundException;
}
