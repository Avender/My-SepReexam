package Library.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LibraryBooksManager implements ILibraryBooks {
    private FileWriter csvWriter;

    public LibraryBooksManager() throws IOException {
        csvWriter = new FileWriter("books.csv", true);
        if (new File("books.csv").length() == 0) {
            csvWriter.append("Title");
            csvWriter.append(",");
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("ISBN");
            csvWriter.append(",");
            csvWriter.append("Author");
            csvWriter.append("\n");
        }
    }

    @Override
    public void addBook(Book book) throws IOException {
        ArrayList<String> bookFields = new ArrayList<String>(Arrays.asList(book.getTitle(), String.valueOf(book.getID()), book.getISBN(), book.getAuthor()));
        csvWriter.append(String.join(",", bookFields));
        csvWriter.append("\n");
        csvWriter.flush();
//        csvWriter.close();

    }

    @Override
    public void borrowBook(Book book) throws FileNotFoundException {

    }

    @Override
    public void returnBook(Book book) throws FileNotFoundException {

    }
}

