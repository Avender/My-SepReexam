package Library.model;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ILibraryItem
{
    void addItem(Item item) throws IOException;
    void borrowBook(Item item) throws FileNotFoundException;
    void returnBook(Item item) throws FileNotFoundException;
}
