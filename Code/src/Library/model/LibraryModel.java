package Library.model;

import java.io.FileNotFoundException;

public interface LibraryModel
{
    void addItem(Item item) throws FileNotFoundException;
    void borrowItem(Item item) throws FileNotFoundException;
    void returnItem(Item item) throws FileNotFoundException;
}
