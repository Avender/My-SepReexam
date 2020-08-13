package Library.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LibraryItemsManager implements ILibraryItem {
    private FileWriter csvWriterBooks, csvWriterArticles, csvWriterCd;

    public LibraryItemsManager() throws IOException {
        csvWriterBooks = new FileWriter("books.csv", true);
        if (new File("books.csv").length() == 0) {
            csvWriterBooks.append("Title");
            csvWriterBooks.append(",");
            csvWriterBooks.append("ID");
            csvWriterBooks.append(",");
            csvWriterBooks.append("ISBN");
            csvWriterBooks.append(",");
            csvWriterBooks.append("Author");
            csvWriterBooks.append("\n");
        }
        csvWriterArticles = new FileWriter("articles.csv", true);
         if(new File("articles.csv").length() == 0)
        {
            csvWriterArticles.append("Title");
            csvWriterArticles.append(",");
            csvWriterArticles.append("ID");
            csvWriterArticles.append(",");
            csvWriterArticles.append("Magazine");
            csvWriterArticles.append(",");
            csvWriterArticles.append("Author");
            csvWriterArticles.append("\n");
        }
        csvWriterCd = new FileWriter("cds.csv", true);
        if(new File("cds.csv").length() == 0)
        {
            csvWriterCd.append("Title");
            csvWriterCd.append(",");
            csvWriterCd.append("ID");
            csvWriterCd.append("\n");
        }
    }

    @Override
    public void addItem(Item item) throws IOException {
        if(item instanceof Book) {
            Book book = (Book)item;
            ArrayList<String> bookFields = new ArrayList<String>(Arrays.asList(book.getTitle(), String.valueOf(book.getID()), book.getISBN(), book.getAuthor()));
            csvWriterBooks.append(String.join(",", bookFields));
            csvWriterBooks.append("\n");
            csvWriterBooks.flush();
        }
        else if (item instanceof Article)
        {
            Article article = (Article) item;
            ArrayList<String> articleFields = new ArrayList<String>(Arrays.asList(article.getTitle(), String.valueOf(article.getID()), article.getMagazine(), article.getAuthor()));
            csvWriterArticles.append(String.join(",", articleFields));
            csvWriterArticles.append("\n");
            csvWriterArticles.flush();
        }
        else if (item instanceof CD)
        {
            CD cd = (CD)item;
            ArrayList<String> cdFields = new ArrayList<String>(Arrays.asList(cd.getTitle(), String.valueOf(cd.getID())));
            csvWriterCd.append(String.join(",", cdFields));
            csvWriterCd.append("\n");
            csvWriterCd.flush();
        }

//        csvWriter.close();

    }

    @Override
    public void borrowBook(Item item) throws FileNotFoundException {

    }

    @Override
    public void returnBook(Item item) throws FileNotFoundException {

    }
}

